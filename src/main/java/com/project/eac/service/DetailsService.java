package com.project.eac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.Details;

import java.util.List;

public interface DetailsService extends IService<Details> {

    List<Details> getDetailByCodeAndNewCodeAndTime(Integer code, Integer newCode, Integer time);
}
