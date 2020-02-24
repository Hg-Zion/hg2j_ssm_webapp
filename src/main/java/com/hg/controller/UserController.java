package com.hg.controller;

import com.hg.pojo.User;
import com.hg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author 黄子柠
 * @date 2020/2/23  16:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //如果不加@RequestParam就会只读取password
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username);
        System.out.println("username:" + username + " psw:" + password);
        System.out.println("user" + user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登录成功
                return "page";
            } else {
                //登录失败
                model.addAttribute("message", "登录失败");
                return "login";
            }
        }
        //找不到这个人
        model.addAttribute("message", "q重新输入正确的登录信息");
        return "login";

    }


    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
