package com.project.eac.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Changes)表实体类
 *
 * @author makejava
 * @since 2023-12-21 19:07:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("changes")
public class Changes  {
    @TableId
    private Integer id;

    private Integer code;
    private Integer start;
    private Integer newCode;
    private Integer time;
    private Integer detailsId;
}
