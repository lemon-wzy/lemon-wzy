package shiro.demo.controller;

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
public class TestUploadFile {

    @PostMapping("file")
    public Object testFile(MultipartFile file, HttpServletRequest httpServletRequest) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        return fileUploadUtil.uploadFile(file,httpServletRequest);
    }
}
