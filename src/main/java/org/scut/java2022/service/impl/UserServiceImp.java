package org.scut.java2022.service.impl;

import org.scut.java2022.mapper.UserMapper;
import org.scut.java2022.pojo.User;
import org.scut.java2022.service.UserService;
import org.scut.java2022.utils.JWTUntil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImp implements UserService {
    private final UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Map<String,Object> check(User user) {
        Map<String,Object> result=new HashMap<>();

        if(user.getUserName()!=null){
            User recordedUser=userMapper.selectPswByUname(user);
            if(recordedUser==null){
                result.put("code","2002");
                result.put("msg","用户不存在");
            }else{
                if(recordedUser.getPassword().equals(user.getPassword())){
                    result.put("code","1000");
                    result.put("token", JWTUntil.getToken(user));
                }
                else {
                    result.put("code","2001");
                    result.put("msg","用户密码错误");
                }
            }
        }
        else{
            result.put("code","2003");
            result.put("msg","用户参数缺失");
        }

        return result;
    }
}
