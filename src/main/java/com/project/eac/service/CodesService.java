package com.project.eac.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.Codes;

import java.util.List;


public interface CodesService extends IService<Codes> {
    List<CodeEntry> getAllCodes();
}
