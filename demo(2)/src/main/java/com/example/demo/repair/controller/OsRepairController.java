package com.example.demo.repair.controller;


import com.example.demo.repair.dto.OsRepairGetDto;
import com.example.demo.repair.entity.OsRepair;
import com.example.demo.repair.service.IOsRepairService;
import com.example.demo.repair.vo.AllRepair;
import com.example.demo.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichi
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/repair/os-repair")
public class OsRepairController {

    @Autowired
    private IOsRepairService iOsRepairService;

    @PostMapping("getAllRepair")
    public R<OsRepairGetDto> getList() {
         return R.data(iOsRepairService.getAllRepair());
    }

    @GetMapping("getMonthCount")
    public R<Integer> getMonthCount(Integer year,Integer month) {
        return R.data(iOsRepairService.getMonthCount(year,month));
    }

}
