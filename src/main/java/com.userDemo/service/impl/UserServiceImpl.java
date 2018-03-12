package com.userDemo.service.impl;

import com.userDemo.common.database.DataSource;
import com.userDemo.dao.IUserDao;
import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaoye on 2018/2/24.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public User checklogin(String username, String pwd) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPwd().equals(pwd)) {
            return user;
        }
        return null;

    }

    //  用户验证
    public boolean autoLogin(Cookie cookie) {
        boolean result = false;
        if (cookie == null || "".equals(cookie.toString())) {
            result = false;
        } else {
            String userc = cookie.getValue();
            String[] cooks = null;
            cooks = userc.split("==");
            User u = new User();
            u.setUsername(cooks[0]);
            u.setPwd(cooks[1]);
            User user = userDao.findByUsername(u.getUsername());
            if (user != null && user.getPwd().equals(u.getPwd())) {
                result = true;
            }
        }
        return result;

    }


}
