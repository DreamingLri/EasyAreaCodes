package com.project.eac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.Code;

import java.util.List;


public interface CodesService extends IService<Code> {
    List<CodeEntry> getAllCodes();
}
