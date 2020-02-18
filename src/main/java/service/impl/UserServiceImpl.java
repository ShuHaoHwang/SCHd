package service.impl;

import dao.UserMapper;
import model.User;
import model.UserExample;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;


    @Autowired
    private void setUserMapper(SqlSessionTemplate sqlSession){
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public Map<String, Object> register(User formUser){

        /*注册结果集代码初定为。
        200：用户名已经存在
        100：无问题完成注册
        */
        Map<String,Object> rs = new HashMap<>();        //这个地方我后期可以进行封装。信息+结果集一并搞定

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(formUser.getUsername());

        if(!userMapper.selectByExample(userExample).isEmpty()){
            rs.put("msg","用户名已经存在");
            rs.put("code",200);
            return rs;
        }

        formUser.setStatus(0);                         //初始状态值设置为0 意为为激活 等待邮箱进行激活验证
        formUser.setUuid(UUID.randomUUID().toString());//设置UUID
        userMapper.insert(formUser);
        rs.put("msg","已经完成注册");
        rs.put("code",100);
        return rs;
    }

    @Override
    public Map<String, Object> checkUser(String str) {
        if(str==null)return null;
        Map<String,Object> rs = new HashMap<>();        //这个地方我后期可以进行封装。信息+结果集一并搞定


        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(str);

        if(!userMapper.selectByExample(userExample).isEmpty()&&str!=null){
            rs.put("msg","用户名已经存在");
            rs.put("code",200);
            return rs;
        }


        rs.put("msg","用户名可以使用");
        rs.put("code",100);
        return rs;
    }

    @Override
    public int countByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(UserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return null;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }


}
