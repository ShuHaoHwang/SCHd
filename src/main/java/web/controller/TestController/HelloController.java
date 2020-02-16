package web.controller.TestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/7
 */

@Controller
@RequestMapping("/helloctl")
public class HelloController {
    @RequestMapping("/index")
    public void index(){
        System.out.println("index被执行");
    }
    @RequestMapping("/show1")
    public void show1(){
        System.out.println("show1被执行");
    }

    @RequestMapping("/show2")
    public void show2(){
        System.out.println("show2被执行");
    }
    @RequestMapping("/TestRepose")
    public void TestRepose(HttpServletResponse response){
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("这是TestRepose打印的！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/TestRepose2")
    public void TestRepose2(){
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("这是TestRepose2打印的！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/goto")
    public String GotoTheNewJsp(){
        /*获取Request路径*/
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        /*设置传输的数据*/
        request.setAttribute("username","ShuHao!!!!");
        return "NewJsp";
    }

    @RequestMapping("/goto2")
    public String GotoTheNewJsp2(){
        System.out.println("重定向被触发了");
        return "redirect:/helloctl/goto";
    }

    @RequestMapping("/getJson")
    public void GetJson(HttpServletResponse response)throws Exception{
        Map<String,Object> data = new HashMap<>();
        data.put("name","ShuHao");
        data.put("age","20");

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(data);
        System.out.println(str);
        response.getWriter().print(str);
    }

    @ResponseBody
    @RequestMapping("/getJson2")
    public Object GetJsonbyObj(){
        Map<String,Object> data = new HashMap<>();
        data.put("name","ZhangSan");
        data.put("age","20");
        return data;
    }


}
