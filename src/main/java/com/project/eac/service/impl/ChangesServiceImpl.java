package com.project.eac.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Change;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.service.ChangesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("changesService")
public class ChangesServiceImpl extends ServiceImpl<ChangesMapper, Change> implements ChangesService {

    @Override
    public List<JSONObject> getChangesWithTime() {
        List<JSONObject> list = new ArrayList<>();
        for(int i = 1980; i< 2023; i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("time", i);
            List<Change> changes = baseMapper.selectList(new LambdaQueryWrapper<Change>().eq(Change::getTime, i));
            jsonObject.put("family", changes);
            list.add(jsonObject);
        }
        return list;
    }
}
