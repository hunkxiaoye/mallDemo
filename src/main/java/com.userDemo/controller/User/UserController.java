package com.userDemo.controller.User;

import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xiaoye on 2018/2/24.
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}