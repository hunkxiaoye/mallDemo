package com.userDemo.Interceptor;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private IUserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取url地址
        String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");
        Cookie cookie = CookieUtil.getCookie(request, "user");
        //当url地址为登录的url的时候跳过拦截器
        if (reqUrl.contains("/login")) {
            return true;
        } else if (!userService.autoLogin(cookie)){
            response.sendRedirect("/userDemo/login");
                //request.getRequestDispatcher("/login").forward(request,response);
                return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }


}