package com.project.eac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Codes;
import com.project.eac.mapper.CodesMapper;
import com.project.eac.service.CodesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("codesService")
public class CodesServiceImpl extends ServiceImpl<CodesMapper, Codes> implements CodesService {

    @Override
    public List<Codes> getAllCodes() {
        return baseMapper.selectList(new LambdaQueryWrapper<>());
    }
}
