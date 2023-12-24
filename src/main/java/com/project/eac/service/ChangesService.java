package com.project.eac.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eac.entity.Change;

import java.util.List;

public interface ChangesService extends IService<Change> {

    List<JSONObject> getChangesWithTime();
}
