package web.model;




import java.util.Date;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/11
 * 用户的实体模型类
 */


public class User {
    private long id;
    private String username;    //登入用户名
    private String password;    //密码
    private String salt;
    private String email;       //邮箱
    private String phone;       //电话
    private String sex;         //性别
    private String nickname;    //昵称
    private String sign;        //个人签名
    private String avatar;      //头像

    private Date createdate;  //创建时间

    private int status;       //User状态：如果为0说明未注册，1：为已注册，2：封禁
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createdate;
    }

    public void setCreateTime(Date createTime) {
        this.createdate = createTime;
    }

    public String toString(){
        return username +"\npd: "+ password + "\nemail: " + email + "\nnickname: " + nickname;
    }
}
