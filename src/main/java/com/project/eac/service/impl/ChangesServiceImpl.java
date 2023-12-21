package com.project.eac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.eac.entity.Change;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.service.ChangesService;
import org.springframework.stereotype.Service;

@Service("changesService")
public class ChangesServiceImpl extends ServiceImpl<ChangesMapper, Change> implements ChangesService {

}
