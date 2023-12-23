package com.project.eac.controller;

import com.project.eac.entity.CodeEntry;
import com.project.eac.entity.vo.ChangeVO;
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
    public List<CodeEntry> getAllCodes(){
        return codesService.getAllCodes();
    }

    @GetMapping("/getSuccessors")
    public List<ChangeVO> getSuccessors(Integer code, Integer start){
        return codesService.getSuccessors(code, start);
    }

    @GetMapping("/getPredecessors")
    public List<ChangeVO> getPredecessors(Integer code, Integer start, Integer end){
        return codesService.getPredecessors(code, start, end);
    }
}
