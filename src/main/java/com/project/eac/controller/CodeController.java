package com.project.eac.controller;

import com.project.eac.entity.Codes;
import com.project.eac.service.CodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {
    private final CodesService codesService;
    @GetMapping("/getAllCodes")
    public List<Codes> getAllCodes(){
        return codesService.getAllCodes();
    }
}
