package com.project.eac.controller;

import com.alibaba.fastjson2.JSONObject;
import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.Codes;
import com.project.eac.service.ChangesService;
import com.project.eac.service.CodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {
    private final CodesService codesService;
    @GetMapping("/getAllCodes")
    public List<CodeEntry> getAllCodes(){
        return codesService.getAllCodes();
    }

}
