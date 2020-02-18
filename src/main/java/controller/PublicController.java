package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ResponseBody
    @RequestMapping("/checkUser")
    public Object User_Register(String username) {
        System.out.println("执行注册");
        System.out.println(username);
        return service.checkUser(username);
    }


    @ResponseBody
    @RequestMapping("/register")
    public Object User_Register(User user) {
        System.out.println("执行注册");
        System.out.println(user);

        return service.register(user);
    }


}
