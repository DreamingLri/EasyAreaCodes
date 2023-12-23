package com.project.eac.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CodeEntry {
    private Integer code;
    private Integer start;

    private String name;
    private Integer end;

    private List<CodeEntry> children;
    private List<TimedCode> successors;
}
