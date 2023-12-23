package com.project.eac.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeVO {
    private String name;
    private Integer code;
    private Integer start;
    private Integer newCode;
    private Integer time;
    private Integer detailsId;
}
