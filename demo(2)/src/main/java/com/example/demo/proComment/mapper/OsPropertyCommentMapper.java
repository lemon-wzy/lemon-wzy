package com.example.demo.proComment.mapper;

import com.example.demo.proComment.dto.OsPropertyCommentDto;
import com.example.demo.proComment.entity.OsPropertyComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lichi
 * @since 2021-07-15
 */
public interface OsPropertyCommentMapper extends BaseMapper<OsPropertyComment> {

    List<Integer> getCommentIdTen(List<Integer> areaList);

    List<OsPropertyCommentDto> getCommentByProId(Integer propertyId);

}
