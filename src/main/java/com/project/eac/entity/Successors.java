package com.project.eac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Successors {
    private Integer code;
    private Integer time;
    private boolean optional;
}
