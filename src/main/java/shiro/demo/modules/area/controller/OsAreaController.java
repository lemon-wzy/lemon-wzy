package shiro.demo.modules.area.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import shiro.demo.modules.area.entity.OsArea;
import shiro.demo.modules.area.service.IOsAreaService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-07-21
 */
@RestController
@RequestMapping("/area/os-area")
public class OsAreaController {

    @Autowired
    private IOsAreaService iOsAreaService;

    @GetMapping("get/name")
    public String getName() {
        return iOsAreaService.getOne(Wrappers.<OsArea>query().lambda().eq(OsArea::getPid,0)).getName();
    }
}
