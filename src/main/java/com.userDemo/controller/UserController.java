package com.userDemo.controller;

import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaoye on 2018/2/24.
 */
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/index")
    public String index() throws IOException {

        return "index";
    }
}
