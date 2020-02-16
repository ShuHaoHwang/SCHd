package web.utils.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;
import web.entity.UserExample;

import java.util.List;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/2/14
 */

@Repository("UserDao")
public class UserDao{
    @Autowired
    UserExample userExample;

    @Autowired
    private SqlSessionTemplate sqlSession;

    public User findByUsername(String n){
        User t = null;
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userExample.createCriteria().andUsernameEqualTo(n);

       List<User> l = userMapper.selectByExample(userExample);//如果为空说明没有重名
       if(!l.isEmpty()){
           t = l.get(0);
       }
        return t;
    }

    public int insert(User user){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int s = userMapper.insert(user);
        return  s;
    }


}
