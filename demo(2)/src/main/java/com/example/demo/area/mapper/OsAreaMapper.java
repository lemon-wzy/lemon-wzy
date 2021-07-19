package com.example.demo.area.mapper;

import com.example.demo.area.entity.OsArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lichi
 * @since 2021-07-13
 */
public interface OsAreaMapper extends BaseMapper<OsArea> {

    List<Integer> getAreaId();

}
