package com.project.eac.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Changes;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.Codes;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.mapper.CodesMapper;
import com.project.eac.service.CodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("codesService")
@RequiredArgsConstructor
public class CodesServiceImpl extends ServiceImpl<CodesMapper, Codes> implements CodesService {
    private final ChangesMapper changesMapper;

    @Override
    public List<CodeEntry> getAllCodes() {
        List<Codes> codesList = baseMapper.selectList(new LambdaQueryWrapper<>()); //codes List
        List<Changes> changesList = changesMapper.selectList(new LambdaQueryWrapper<>()); //changes List

        List<CodeEntry> codeEntryList = generateCodeEntry(codesList, changesList); //function ↓

        return codeEntryList; // return value
    }
    private List<CodeEntry> generateCodeEntry(List<Codes> codesList, List<Changes> changesList){ //function
        List<CodeEntry> codeEntryList = new ArrayList<>(); //new return value

        return  codeEntryList; //return
    }
}
