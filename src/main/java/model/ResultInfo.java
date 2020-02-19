package model;

import java.util.HashMap;
import java.util.Map;

public class ResultInfo {
    /*注册结果集代码初定为。
        200：用户名已经存在
        100：无问题完成注册
    */
    private int status;

    private String msg;    //结果集信息

    private Map<String, Object> rs; //存储结果的容器




    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getRs() {
        rs = new HashMap<>();
        rs.put("code",status);
        rs.put("msg",msg);
        return rs;
    }

    public void setRs(Map<String, Object> rs) {
        this.rs = rs;
    }



}
