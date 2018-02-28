package com.userDemo.dao;

import com.userDemo.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by xiaoye on 2018/2/24.
 */
@Component
public interface IUserDao {
    User selectUser(long id);

    User findByUsername(String username);

}
