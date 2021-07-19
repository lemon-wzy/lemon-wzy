package com.example.demo.repair.service;

import com.example.demo.repair.dto.OsRepairGetDto;
import com.example.demo.repair.entity.OsRepair;
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
public interface IOsRepairService extends IService<OsRepair> {

    /**
     * 柯城总事件
     * @return
     */
    OsRepairGetDto getAllRepair();

    Integer getMonthCount(Integer year,Integer month);

}
