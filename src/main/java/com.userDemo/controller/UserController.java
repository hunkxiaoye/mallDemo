package com.userDemo.controller;

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
    @Resource
    private IUserService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpSession session) throws IOException {
        Cookie cookie[] = request.getCookies();
        String[] cooks = null;
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                Cookie c = cookie[i];
                String userc = c.getValue();
                cooks = userc.split("==");
                if (cooks.length == 2) {
                    String username = cooks[0];
                    String password = cooks[1];
                    User user = new User();
                    user.setUsername(username);
                    user.setPwd(password);

                    //通过此只用用户名和密码的user找到完整的user对象的信息，并保存在session
                    userService.autoLogin(user, session, request);
                }
            }
        }
        return "index";
    }
}