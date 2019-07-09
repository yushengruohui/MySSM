package com.yusheng.controllers;

import com.yusheng.pojo.User;
import com.yusheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String getUserByName(Model model, User user) {
        User user2 = userService.getUserByName(user.getuName());
        System.out.println(user2);
        model.addAttribute("user", user2);
        return "page/jsp/dome1";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        int flag = userService.updateUser(user);
        if (flag == 1) {
            System.out.println("更新用户成功");
        } else {
            System.out.println("更新用户失败");
        }
        return "page/jsp/dome1";
    }
}
