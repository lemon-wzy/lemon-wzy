package shiro.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author lichi
 */
@Component
public class FileUploadUtil {

    public FileUploadUtil() {

    }

    private  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 文件保存路径
     */
    private static String fileSavePath;

    @Value("${file.save-path}")
    public void setFileSavePath(String path) {
       this.fileSavePath = path;
    }

    /**
     * 文件访问端口
     */
    private static String port;

    @Value("${file.save-port}")
    public void setPort(String port) {
       this.port = port;
    }

    public  Object uploadFile(MultipartFile file, HttpServletRequest httpServletRequest) {

        //后半段目录路径
        String directory = simpleDateFormat.format(new Date());

        //文件完整路径
        File dir = new File(fileSavePath + directory);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        System.out.println("文件保存位置"+fileSavePath+directory);

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replaceAll("-","") +suffix;
        File newFile = new File(fileSavePath+directory+newFileName);

        Map<String, Object> files = new HashMap<>();
        Map<String, String > map = new HashMap<>();

        try {
            file.transferTo(newFile);
            String url = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName()+":" +port+"/"+directory+newFileName;
            System.out.println("this is file url" + url);
            map.put("file",url);
            files.put("files",map);
            return files;
        } catch (Exception e) {
            files.put("error",e.getMessage());
            return files;
        }
    }
}
