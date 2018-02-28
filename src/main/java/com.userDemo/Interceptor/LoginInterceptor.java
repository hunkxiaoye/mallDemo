package com.userDemo.Interceptor;

import com.userDemo.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {


            //获取url地址
            String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");
            //当url地址为登录的url的时候跳过拦截器
            if(reqUrl.contains("/login")){
                return true;
            }else{
                HttpSession session=request.getSession();
                Object obj=session.getAttribute("user");
                if(obj==null||"".equals(obj.toString())){
                    request.getRequestDispatcher("/login").forward(request,response);
                    return false;
                }
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
