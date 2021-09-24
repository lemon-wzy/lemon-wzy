package shiro.demo.component;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密
 * @author lichi
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
//        return null;
        /**
         * 可以自定义密码加密规则
         */
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
//        return false;
        return encode(charSequence).equals(s);
    }
}
