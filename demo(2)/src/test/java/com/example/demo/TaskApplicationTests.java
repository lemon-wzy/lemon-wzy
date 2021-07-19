package com.example.demo;

import com.example.demo.area.service.IOsAreaService;
import com.example.demo.repair.service.IOsRepairService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskApplicationTests {

    @Autowired
    private IOsAreaService iOsAreaService;

    @Autowired
    private IOsRepairService iOsRepairService;

    @Test
    void contextLoads() {
//        List<Integer> integerList = iOsAreaService.getAreaId();
//        System.out.println(integerList);
       // iOsRepairService.getAllRepair(true,false,"水电报修");
        iOsRepairService.getMonthCount(2020,8);
    }

}
