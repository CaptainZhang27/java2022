package org.scut.java2022.service.impl;

import org.scut.java2022.mapper.UserMapper;
import org.scut.java2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean check(String userName,String password) {
        String recordedPassword=userMapper.selectPswByUname(userName);
        if(recordedPassword==password)
            return true;
        else
            return false;
    }
}
