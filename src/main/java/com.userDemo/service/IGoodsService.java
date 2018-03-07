package com.userDemo.service;

import com.userDemo.model.Goods;

import java.util.List;

public interface IGoodsService {

    List<Goods> findGoodsBytatus(int status);
    Goods findGoodsByIdAndStock(int id,int stock);
    Goods findGoodsById(int id);
}
