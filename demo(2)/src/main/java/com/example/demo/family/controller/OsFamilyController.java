package com.example.demo.family.controller;


import com.example.demo.family.entity.OsFamily;
import com.example.demo.family.service.IOsFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichi
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/family/os-family")
public class OsFamilyController {
    @Autowired
    private IOsFamilyService iOsFamilyService;


    @GetMapping("get/list")
    public List<OsFamily> getList() {
      return iOsFamilyService.selectListWithCardNo();
    }
}
