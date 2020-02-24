package com.hg.service.impl;

import com.hg.mapper.UserMapper;
import com.hg.pojo.User;
import com.hg.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 黄子柠
 * @date 2020/2/23  15:58
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    public User login(String username) {
        return userMapper.login(username);
    }
}
