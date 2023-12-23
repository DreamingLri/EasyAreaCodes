package com.project.eac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.Code;
import com.project.eac.entity.vo.ChangeVO;

import java.util.List;


public interface CodesService extends IService<Code> {
    List<CodeEntry> getAllCodes();

    List<ChangeVO> getSuccessors(Integer code, Integer start);

    List<ChangeVO> getPredecessors(Integer code, Integer start, Integer end);
}
