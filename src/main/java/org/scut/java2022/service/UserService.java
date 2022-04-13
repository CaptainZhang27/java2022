package org.scut.java2022.service;

import org.scut.java2022.pojo.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> check(User user);
}
