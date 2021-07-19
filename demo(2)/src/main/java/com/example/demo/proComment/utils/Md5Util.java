package com.example.demo.proComment.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.openapi.entity.OsOpenapi;
import com.example.demo.openapi.service.IOsOpenapiService;
import com.example.demo.proComment.entity.OsPropertyComment;
import com.example.demo.proComment.mapper.OsPropertyCommentMapper;
import com.example.demo.proComment.service.IOsPropertyCommentService;
import com.example.demo.proComment.service.impl.OsPropertyCommentServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.query;

@Component
public class Md5Util {

    @Autowired
    private static IOsPropertyCommentService osPropertyCommentService;
    @Autowired
    private static IOsOpenapiService osOpenapiService;

    @Autowired
    public Md5Util(IOsPropertyCommentService osPropertyCommentService,IOsOpenapiService openapiService) {
        this.osPropertyCommentService = osPropertyCommentService;
        this.osOpenapiService = openapiService;
    }

    public static String md5(String inStr) {
        try {
            return DigestUtils.md5Hex(inStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }

    public static Map<String,String> verify(HttpServletRequest request) {

        Map<String,String > resultmap = new HashMap<>();
        // 获取url参数
        @SuppressWarnings("unchecked")
        String date = request.getHeaders("date").toString();
        String sign = request.getHeaders("sign").toString();
        String appId = request.getHeaders("appid").toString();
        String path = request.getContextPath().toString();
        int index = path.lastIndexOf("/");
        String methodName = path.substring(index+1,path.length()).toLowerCase();

        OsOpenapi openapi = osOpenapiService.getOne(Wrappers.<OsOpenapi>query().lambda().eq(OsOpenapi::getAppid,appId));
        if (openapi == null) {
            resultmap.put("msg","appId错误没有调用此接口的权限");
            resultmap.put("code","0");
            return resultmap;
        }

        String scret = openapi.getSecret();
        String str = appId+scret+methodName+date;
        String mySign = md5(str);
        if (!mySign.equals(sign)) {
            resultmap.put("msg","sign签名认证失败，没有权限调用此接口");
            resultmap.put("code","0");
            return resultmap;
        }

        resultmap.put("code","1");
        resultmap.put("msg","签名认证成功");

        return resultmap;

    }

}
