package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SqlSession session;

    String namespace = "com.mycompany.myseat.dao.UserMapper.";

    @Override
    public int insertUser(User user) throws Exception{
        return session.insert(namespace+"insertUser", user);
    }

    @Override
    public User selectUser(String email) throws Exception{
        return session.selectOne(namespace+"selectUser", email);
    }

    @Override
    public int emailCheck(String email) throws Exception{
        return session.selectOne(namespace+"emailCheck", email);
    }

    @Override
    public int nicknameCheck(String nickname) throws Exception{
        return session.selectOne(namespace+"nicknameCheck", nickname);
    }

    @Override
    public String getNickName(String email) throws Exception{
        return session.selectOne(namespace+"getNickName", email);
    }
}
