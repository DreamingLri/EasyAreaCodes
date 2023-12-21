package com.project.eac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.common.Level;
import com.project.eac.entity.Change;
import com.project.eac.entity.Code;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.TimedCode;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.mapper.CodesMapper;
import com.project.eac.service.CodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("codesService")
@RequiredArgsConstructor
public class CodesServiceImpl extends ServiceImpl<CodesMapper, Code> implements CodesService {
    private final ChangesMapper changesMapper;

    @Override
    public List<CodeEntry> getAllCodes() {
        List<Code> codes = baseMapper.selectList(new LambdaQueryWrapper<>()); //codes List
        List<Change> changes = changesMapper.selectList(new LambdaQueryWrapper<>()); //changes List

        return generateCodeEntries(codes, changes); // return value
    }

    private List<CodeEntry> generateCodeEntries(List<Code> codes, List<Change> changes) {
        Map<TimedCode, List<TimedCode>> groupedChanges = new HashMap<>();
        for (Change change : changes) {
            groupedChanges.computeIfAbsent(new TimedCode(change.getCode(), change.getStart()), k -> new ArrayList<>())
                    .add(new TimedCode(change.getNewCode(), change.getTime()));
        }

        List<CodeEntry> res = new ArrayList<>();

        for (Code codeRec : codes) {
            List<CodeEntry> entries = res;
            int code = codeRec.getCode();
            int start = codeRec.getStart();
            Level level = Level.from_code(code);

            int provCode = code / 10000 * 10000;
            if (level != Level.Province) {
                entries = entries.stream()
                        .filter(e -> e.getCode() == provCode)
                        .findAny().orElseThrow().getChildren();
                if (level == Level.County) {
                    int prefCode = code / 100 * 100;
                    var prefEntry = entries.stream()
                            .filter(e -> e.getCode() == prefCode && e.getStart() <= start)
                            .findAny();
                    if (prefEntry.isPresent()) {
                        entries = prefEntry.get().getChildren();
                    }
                }
            }

            entries.add(new CodeEntry(code, start, codeRec.getName(), codeRec.getEnd(),
                    new ArrayList<>(),
                    groupedChanges.get(new TimedCode(code, start))));
        }

        return res;
    }
}
