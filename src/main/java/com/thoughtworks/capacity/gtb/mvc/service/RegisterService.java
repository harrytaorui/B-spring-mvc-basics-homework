package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.GlobalException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {
    private Map<String, User> userMap = new HashMap<>();


    public void register(User user) throws GlobalException {
        if (userMap.containsKey(user.getUsername())) {
            throw new GlobalException("用户已存在");
        }
        user.setId(userMap.size() + 1);
        userMap.put(user.getUsername(), user);
    }

    public User login(String username, String password) throws GlobalException {
        if (!userMap.containsKey(username)) {
            throw new GlobalException("用户名错误");
        }
        User user = userMap.get(username);
        if (!user.getPassword().equals(password)) {
            throw new GlobalException("密码错误");
        }
        return user;
    }
}
