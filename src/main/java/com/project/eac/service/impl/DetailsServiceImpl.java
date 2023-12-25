package com.project.eac.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Change;
import com.project.eac.entity.Details;
import com.project.eac.entity.vo.DetailVO;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.mapper.DetailsMapper;
import com.project.eac.mapper.struct.BeanCopyUtils;
import com.project.eac.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<DetailVO> getDetailByChangesList(List<Change> changes) {
        List<DetailVO> list = new ArrayList<>();
        for (Change change : changes) {
            Details detail = baseMapper.selectById(change.getDetailsId());
            if(!ObjectUtil.isEmpty(detail)){
                DetailVO detailVO = BeanCopyUtils.INSTANCE.toDetailVO(change);
                detailVO.setId(detail.getId());
                detailVO.setText(detail.getText());
                list.add(detailVO);
            }
        }
        return list;
    }

    @Override
    public DetailVO getDetailByChange(Change change) {
        DetailVO detailVO = null;
        Details details = baseMapper.selectById(change.getDetailsId());
        if(!ObjectUtil.isEmpty(details)){
            detailVO = BeanCopyUtils.INSTANCE.toDetailVO(change);
            detailVO.setId(details.getId());
            detailVO.setText(details.getText());
        }
        return detailVO;
    }
}
