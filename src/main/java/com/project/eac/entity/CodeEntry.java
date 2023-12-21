package com.project.eac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeEntry {
    private Integer code;
    private Integer start;

    private String name;
    private Integer end;

    private List<CodeEntry> children;
    private List<TimedCode> successors;
}
