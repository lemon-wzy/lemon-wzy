package com.example.demo.repair.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.area.entity.OsArea;
import com.example.demo.area.service.IOsAreaService;
import com.example.demo.repair.dto.OsRepairGetDto;
import com.example.demo.repair.entity.OsRepair;
import com.example.demo.repair.mapper.OsRepairMapper;
import com.example.demo.repair.service.IOsRepairService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lichi
 * @since 2021-07-13
 */
@Service
public class OsRepairServiceImpl extends ServiceImpl<OsRepairMapper, OsRepair> implements IOsRepairService {

    @Autowired
    private IOsAreaService iOsAreaService;

    @Override
    public OsRepairGetDto getAllRepair() {
        OsRepairGetDto osRepairGetDto = new OsRepairGetDto();
        osRepairGetDto.setAllEventCount(this.getAllRepairs(false, false, null));

        osRepairGetDto.setIsOverCount(this.getAllRepairs(true, false, null));

        osRepairGetDto.setInFourCount(this.getAllRepairs(false, true, null));

        osRepairGetDto.setPublicCount(this.getAllRepairs(false, false, "公共维修"));

        osRepairGetDto.setComplaintCount(this.getAllRepairs(false, false, "投诉举报"));

        osRepairGetDto.setReportingCount(this.getAllRepairs(false, false, "小区报事"));

        osRepairGetDto.setFamilyCount(this.getAllRepairs(false, false, "居家维修"));

        return osRepairGetDto;
    }

    public Integer getAllRepairs(Boolean isOver, Boolean eventId, String type) {
        List<Integer> areaList = iOsAreaService.getAreaId();
        QueryWrapper<OsRepair> queryWrapper = new QueryWrapper<>();
        if (isOver) {
            queryWrapper.lambda().eq(OsRepair::getIsover, 0);
        }
        if (eventId) {
            queryWrapper.lambda().isNotNull(OsRepair::getEventId);
        }
        if (type != null) {
            if (!type.isEmpty()) {
                queryWrapper.lambda().eq(OsRepair::getType, type);
            }
        }
        queryWrapper.lambda().in(OsRepair::getAreaId, areaList);
        List<OsRepair> osRepairList = baseMapper.selectList(queryWrapper);
        return osRepairList.size();
    }

    @Override
    public Integer getMonthCount(Integer year, Integer month) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Integer> areaList = iOsAreaService.getAreaId();
        QueryWrapper<OsRepair> queryWrapper = new QueryWrapper<>();
        String monthstart = null;
        String monthend = null;
        if (month != 12) {
            if (month > 0 && month < 10) {
                monthstart = "0" + month;
                Integer months = month + 1;
                monthend = "0" + months;
            } else {
                monthstart = month.toString();
                Integer months = month + 1;
                monthend = months.toString();
            }
        }else {
            monthstart = month.toString();
            monthend = "01";
        }
        queryWrapper.lambda().between(OsRepair::getCreateTime
                , LocalDateTime.parse("" + year + "-" + monthstart + "-01 00:00:00", df)
                , LocalDateTime.parse("" + year + "-" + monthend + "-01 00:00:00", df));
        queryWrapper.lambda().in(OsRepair::getAreaId, areaList);
        return baseMapper.selectList(queryWrapper).size();
    }

}
