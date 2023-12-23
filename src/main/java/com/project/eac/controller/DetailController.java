package com.project.eac.controller;

import com.project.eac.entity.Details;
import com.project.eac.service.ChangesService;
import com.project.eac.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {
    private final DetailsService detailsService;

    @GetMapping("/getDetailByCodeAndNewCodeAndTime")
    private Details getDetailByCodeAndNewCodeAndTime(Integer code, Integer newCode, Integer time){
        return detailsService.getDetailByCodeAndNewCodeAndTime(code, newCode, time);
    }
}
