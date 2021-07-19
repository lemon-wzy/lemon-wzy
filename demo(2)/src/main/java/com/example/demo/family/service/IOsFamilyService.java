package com.example.demo.family.service;

import com.example.demo.family.entity.OsFamily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichi
 * @since 2021-07-09
 */
public interface IOsFamilyService extends IService<OsFamily> {

    List<OsFamily> selectListWithCardNo();
}
