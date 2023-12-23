package com.project.eac.mapper.struct;

import com.project.eac.entity.Change;
import com.project.eac.entity.vo.ChangeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanCopyUtils {
    BeanCopyUtils INSTANCE = Mappers.getMapper(BeanCopyUtils.class);

    ChangeVO toChangeVO(Change change);
}
