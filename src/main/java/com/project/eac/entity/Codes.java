package com.project.eac.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("codes")
public class Codes  {
    @TableId
    private Integer code;
    private Integer start;

    private String name;
    private Integer end;
}
