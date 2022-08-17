package com.mycompany.myseat.dao;

import com.mycompany.myseat.domain.User;

public interface UserDao {

    int insertUser(User user) throws Exception;

    User selectUser(String email) throws Exception;

    int emailCheck(String email) throws Exception;

    int nicknameCheck(String nickname) throws Exception;
}
