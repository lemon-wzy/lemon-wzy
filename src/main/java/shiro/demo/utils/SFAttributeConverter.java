package shiro.demo.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.persistence.AttributeConverter;

/**
 * 数据加密工具类
 * @author lichi
 */
@Component
public class SFAttributeConverter implements AttributeConverter {
    @Override
    public Object convertToDatabaseColumn(Object o) {
        //// TODO: 2021/9/27 加密
      return MD5Util.convertMD5(o.toString());

    }

    @Override
    public Object convertToEntityAttribute(Object o) {
        // TODO: 2021/9/27 解密
//        Object obj  = DigestUtils.md5DigestAsHex(o.toString().getBytes());
        return MD5Util.convertMD5(o.toString());

    }
}
