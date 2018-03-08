package com.userDemo.service.impl;

import com.userDemo.dao.ICartDao;
import com.userDemo.model.Cart;
import com.userDemo.model.Goods;
import com.userDemo.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartDao cartDao;

    public List<Cart> selectCart(int userid) {

        return cartDao.selectCart(userid);
    }

    public void addList(List<Cart> list) {
        cartDao.addList(list);
    }

    public void add(Cart cart) {
        cartDao.add(cart);
    }

    public void deleteCart(Cart cart) {

        cartDao.deleteCart(cart);
    }
}
