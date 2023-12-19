package com.project.eac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.Codes;

import java.util.List;


public interface CodesService extends IService<Codes> {

    List<Codes> getAllCodes();
}
