package com.mycompany.myseat.service;

import com.mycompany.myseat.domain.User;

public interface UserService {
    int signUp(User user) throws Exception;

    User login(String email) throws Exception;

    int getEmailCheck(String email) throws Exception;

    int getNicknameCheck(String nickname) throws Exception;

    String getNickName(String email) throws Exception;
}
