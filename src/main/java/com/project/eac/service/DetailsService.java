package com.project.eac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.Change;
import com.project.eac.entity.Details;
import com.project.eac.entity.vo.DetailVO;

import java.util.List;

public interface DetailsService extends IService<Details> {

    Details getDetailByCodeAndNewCodeAndTime(Integer code, Integer newCode, Integer time);

    List<DetailVO> getDetailByChangesList(List<Change> changes);

    DetailVO getDetailByChange(Change change);

    boolean updateDetail(DetailVO detailVO);

    boolean updateDetails(List<DetailVO> detailVOList);
}
