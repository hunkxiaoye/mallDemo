package com.userDemo.service;

import com.userDemo.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaoye on 2018/2/24.
 */
public interface IUserService {
    //登录校验
    User checklogin(String username,String pwd);

    // 自动登录
   boolean autoLogin(Cookie cookie);
}
