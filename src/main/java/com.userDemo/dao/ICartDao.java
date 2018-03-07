package com.userDemo.dao;

import com.userDemo.model.Goods;

import java.util.List;

public interface ICartDao {
    List<Goods> selectCart(int userid);
    int addCart(int goodsid,int userid,int amount);
    int deleteCart( int cartid,int userid);
}
