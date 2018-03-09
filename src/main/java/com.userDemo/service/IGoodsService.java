package com.userDemo.service;

import com.userDemo.model.Goods;

import java.util.ArrayList;
import java.util.List;

public interface IGoodsService {

    List<Goods> findGoodsBytatus(int status);

    Goods findGoodsByIdAndStock(int id, int stock);

    Goods findGoodsById(int id);

    void add(Goods goods);

    ArrayList<Goods> findGoodsAll();

    void Update(Goods goods);
}
