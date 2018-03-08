package com.userDemo.service;

import com.userDemo.model.Cart;
import com.userDemo.model.Goods;

import java.util.List;

public interface ICartService {
    List<Cart> selectCart(int userid);

    void addList(List<Cart> list);

    void add(Cart cart);

    void deleteCart(Cart cart);
}
