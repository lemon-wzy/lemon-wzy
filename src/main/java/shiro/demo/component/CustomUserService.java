package shiro.demo.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import shiro.demo.entity.User;
import shiro.demo.mapper.UserMapper;
import shiro.demo.service.UserService;

/**登录专用类
 * 自定义类，实现了UserDetailsService接口，用户登录时调用的第一类
 * @author lichi
 */
@Component
public class CustomUserService implements UserDetailsService {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
        //在这里可以自己调用数据库，对username进行查询，看看在数据库中是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,s);
//        User user = userMapper.selectOne(queryWrapper);
        User user = userService.getOne(queryWrapper);
        if (null == user ) {
            throw new UsernameNotFoundException("用户不存在");
        }
        MyUserDetails myUserDetail = new MyUserDetails();
        myUserDetail.setUsername(s);
        myUserDetail.setPassword(user.getPassword());
        return myUserDetail;
    }
}
