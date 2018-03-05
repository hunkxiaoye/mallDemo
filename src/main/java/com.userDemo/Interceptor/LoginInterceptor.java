package com.userDemo.Interceptor;

import com.userDemo.common.CookieUtil;
import com.userDemo.common.ToolsUtils;
import com.userDemo.service.IUserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private IUserService userService;

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取url地址
        String url = request.getServletPath();
        if (url.endsWith("login") || url.endsWith("loginVerify")) {
            return true;
        }
        if (!CookieUtil.isLogin(request)) {
                String returnurl = request.getContextPath() + request.getServletPath() + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
                response.sendRedirect(request.getContextPath() + "/login?returnurl=" + ToolsUtils.urlEncode(returnurl));

            return false;
        } else {
            CookieUtil.refreshLogin(request, response, 1800);
            return true;
        }
    }
}