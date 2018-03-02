package com.userDemo.controller.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userDemo.common.CookieUtil;
import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoye on 2018/2/26.
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    //登录页面显示
    @RequestMapping(value = "/login")
    public String loginView() {
        return "login";
    }
    //登录验证
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) throws Exception {
            Map<String, Object> map = new HashMap<String, Object>();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String auto = request.getParameter("auto");
            User user = userService.checklogin(username, password);
            if (user == null) {
                map.put("code", 0);
                map.put("msg", "用户名或密码错误！");
            } else {
                //登录成功
                map.put("code", 1);
                map.put("msg", "");
                //添加cookie
                if (auto != null) {
                    CookieUtil.setCookie(response, "user", user.getUsername() + "==" + user.getPwd());
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writeValueAsString(map);
            return result;
    }


    //退出登录
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) throws Exception {
        session.removeAttribute("user");
        session.invalidate();
        return "index";
    }


}