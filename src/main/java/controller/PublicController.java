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
    public class PublicController {

    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping("/user/register")
    public Object User_Register(User formUser){
        System.out.println("一个用户已经开始注册\n" + formUser);      //用来前期数据接收测试【测试完毕可以删除】
        return service.register(formUser);
    }
}
