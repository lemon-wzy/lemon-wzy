package shiro.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shiro.demo.utils.FileUploadUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lichi
 */
@RestController
@RequestMapping("test/upload")
@Api(tags = "测试")
public class TestUploadFile {
    @ApiOperation("测试文件上传")
    @PostMapping("file")
    public Object testFile(MultipartFile file, HttpServletRequest httpServletRequest) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        return fileUploadUtil.uploadFile(file,httpServletRequest);
    }
}
