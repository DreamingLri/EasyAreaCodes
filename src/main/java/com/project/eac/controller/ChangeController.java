package com.project.eac.controller;

import cn.hutool.json.JSONObject;
import com.project.eac.entity.Change;
import com.project.eac.mapper.ChangesMapper;
import com.project.eac.service.ChangesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/change")
@RequiredArgsConstructor
public class ChangeController {
    private final ChangesService changesService;

    @GetMapping("/getChangesWithTime")
    public List<JSONObject> getChangesWithTime(){
        return changesService.getChangesWithTime();
    }
}
