package com.bjpowernode.crm.setting.service;

import com.bjpowernode.crm.setting.domain.User;

import javax.security.auth.login.LoginException;

public interface UserService {
    User login(String loginAct,String loginPwd,String ip) throws LoginException;
}
