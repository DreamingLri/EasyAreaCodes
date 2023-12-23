package com.project.eac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Change;
import com.project.eac.entity.Details;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.mapper.DetailsMapper;
import com.project.eac.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailsService")
@RequiredArgsConstructor
public class DetailsServiceImpl extends ServiceImpl<DetailsMapper, Details> implements DetailsService {
    private final ChangesMapper changesMapper;
    @Override
    public Details getDetailByCodeAndNewCodeAndTime(Integer code, Integer newCode, Integer time) {
        Integer detailsId = changesMapper.selectOne(new LambdaQueryWrapper<Change>()
                .eq(Change::getCode, code)
                .eq(Change::getNewCode, newCode)
                .eq(Change::getTime, time)).getDetailsId();
        return baseMapper.selectOne(new LambdaQueryWrapper<Details>()
                .eq(Details::getId, detailsId));
    }
}
