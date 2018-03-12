package com.userDemo.service;

import com.userDemo.common.database.DataSource;
import com.userDemo.model.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> selectCart(int userid);

    @DataSource("write")
    void addList(List<Cart> list);

    @DataSource("write")
    void add(Cart cart);

    @DataSource("write")
    void deleteCart(Cart cart);

    @DataSource("write")
    void deleteCartAll(int user_id);
}
