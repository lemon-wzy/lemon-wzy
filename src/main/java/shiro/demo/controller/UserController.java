package shiro.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shiro.demo.entity.User;
import shiro.demo.service.UserService;

/**
 * user控制器
 * @author lichi
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public Boolean add (@RequestBody User user) {
        System.out.println("this is add");
        return userService.saveOrUpdate(user);
    }
}
