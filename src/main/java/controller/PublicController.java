package controller;

import model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/17
 */

@Controller
@RequestMapping("/user")
public class PublicController {

    @Autowired
    private UserService service;

    @RequestMapping("/register")
    @ResponseBody
    public Object User_Register(String username, String email, String password) {
        System.out.println("执行注册");
        System.out.println("前端传来的数据：" + username + " " + email + " " + password);

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);


        return service.register(user);
    }

}
