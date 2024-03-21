package com.project.eac.controller;

import com.project.eac.entity.Change;
import com.project.eac.entity.Details;
import com.project.eac.entity.vo.DetailVO;
import com.project.eac.service.ChangesService;
import com.project.eac.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getDetailByChangesList")
    private List<DetailVO> getDetailByChangesList(@RequestBody List<Change> changes){
        return detailsService.getDetailByChangesList(changes);
    }

    @PostMapping("/getDetailByChange")
    private DetailVO getDetailByChange(@RequestBody Change change){
        return detailsService.getDetailByChange(change);
    }

    @PostMapping("/updateDetail")
    private boolean updateDetail(@RequestBody DetailVO detailVO){
        return detailsService.updateDetail(detailVO);
    }

    @PostMapping("updateDetails")
    private boolean updateDetails(@RequestBody List<DetailVO> detailVOList){
        return detailsService.updateDetails(detailVOList);
    }
}
