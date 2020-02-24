package com.hg.mapper;

import com.hg.pojo.User;

/**
 * @author 黄子柠
 * @date 2020/2/23  14:23
 */
public interface UserMapper {

    /**
     * @param username 传入的用户名
     * @return 一个用户对象
     *
     * 返回用户对象以获取密码以验证是否登录成功
     */
    User login(String username);
}
