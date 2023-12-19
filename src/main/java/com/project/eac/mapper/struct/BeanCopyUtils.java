package com.project.easyareacode.mapper.struct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanCopyUtils {
    BeanCopyUtils INSTANCE = Mappers.getMapper(BeanCopyUtils.class);
}
