package com.example.demo.proComment.controller;


import com.example.demo.family.entity.OsFamily;
import com.example.demo.proComment.dto.OsPropertyCommentDto;
import com.example.demo.proComment.service.IOsPropertyCommentService;
import com.example.demo.proComment.utils.Md5Util;
import com.example.demo.repair.dto.OsRepairGetDto;
import com.example.demo.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichi
 * @since 2021-07-15
 */
@RestController
@RequestMapping("/proComment/os-property-comment")
public class OsPropertyCommentController {

    @Autowired
    private IOsPropertyCommentService iOsPropertyCommentService;

    @GetMapping("getCommentList")
    public R<List<List<OsPropertyCommentDto>>> getList(HttpServletRequest request) throws Exception {
        System.out.println(request);
        Map<String,String > resultMap = Md5Util.verify(request);
        if (resultMap.get("code").equals("0")) {
            return R.fail(resultMap.get("msg"));
        }
        return R.data(iOsPropertyCommentService.getPropertyCommentList());
    }

}
