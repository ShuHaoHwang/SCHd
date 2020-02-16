package web.controller.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/13
 */

@Controller
public class Hellocontroller2 {
    @RequestMapping("/hello")
    public void show(){
        System.out.println("hello is ok!!");
    }

    @RequestMapping("/TestRepose")
    public void TestRepose(HttpServletResponse response){
        try {
            response.getWriter().print("这是TestRepose打印的！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
