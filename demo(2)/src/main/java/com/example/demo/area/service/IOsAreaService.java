package com.example.demo.area.service;

import com.example.demo.area.entity.OsArea;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichi
 * @since 2021-07-13
 */
public interface IOsAreaService extends IService<OsArea> {

    List<Integer> getAreaId();

}
