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
@TableName("changes")
public class Change {
    @TableId
    private Integer id;

    private Integer code;
    private Integer start;
    private Integer newCode;
    private Integer time;
    private Integer detailsId;
}
