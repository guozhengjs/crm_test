package com.bjpowernode.crm.setting.dao;

import com.bjpowernode.crm.setting.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String,String> map);
}
