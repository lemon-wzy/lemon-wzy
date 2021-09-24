package shiro.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shiro.demo.entity.User;
import shiro.demo.mapper.UserMapper;

/**
 * @author lichi
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IService<User> {
}
