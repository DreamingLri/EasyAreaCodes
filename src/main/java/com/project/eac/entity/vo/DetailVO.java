package com.project.eac.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVO {
    private Integer id;
    private Integer code;
    private String name;
    private Integer start;
    private Integer newCode;
    private String newName;
    private Integer newStart;
    private Integer time;
    private String text;
}
