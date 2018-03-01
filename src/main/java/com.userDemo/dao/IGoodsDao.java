package com.userDemo.dao;

import com.userDemo.controller.Goods.GoodsController;
import com.userDemo.model.Goods;

import java.util.List;

public interface IGoodsDao {
    List<Goods> findGoodsAll();
}
