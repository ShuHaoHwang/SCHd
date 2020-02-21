package model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ResultInfo {
    /*注册结果集代码初定为。
        200：用户名已经存在
        100：无问题完成注册
    */
    private int status;

    private String msg;    //结果集信息

    private Map<String, Object> rs; //存储结果的容器

    //单独给了一个接收的方法，如果使用带参构造不合适
    public void setResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    public Map<String, Object> getRs() {
        rs = new HashMap<>();
        rs.put("code", status);
        rs.put("msg", msg);
        return rs;
    }

}
