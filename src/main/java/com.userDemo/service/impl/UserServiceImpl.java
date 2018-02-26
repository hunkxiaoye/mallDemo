package com.userDemo.service.impl;

import com.userDemo.dao.IUserDao;
import com.userDemo.model.User;
import com.userDemo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaoye on 2018/2/24.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
