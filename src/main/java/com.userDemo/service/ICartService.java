package com.userDemo.service;

import com.userDemo.model.Goods;

import java.util.List;

public interface ICartService {
    List<Goods> selectCart(int userid);
    int addCart(int goodsid,int userid,int amount);
    int deleteCart( int cartid,int userid);
}
