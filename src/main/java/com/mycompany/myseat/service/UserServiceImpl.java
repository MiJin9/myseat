package com.mycompany.myseat.service;

import com.mycompany.myseat.dao.UserDao;
import com.mycompany.myseat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int signUp(User user) throws Exception{
        return userDao.insertUser(user);
    }

    @Override
    public User login(String email) throws Exception{
        return userDao.selectUser(email);
    }

    @Override
    public int getEmailCheck(String email) throws Exception{
        return userDao.emailCheck(email);
    }

    @Override
    public int getNicknameCheck(String nickname) throws Exception{
        return userDao.nicknameCheck(nickname);
    }

    @Override
    public String getNickName(String email) throws Exception{
        return userDao.getNickName(email);
    }

    @Override
    public String searchEmail(String name, String nickname) throws Exception{
        return userDao.selectEmail(name, nickname);
    }
}
