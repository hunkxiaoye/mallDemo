package com.userDemo.service;

import com.userDemo.common.database.DataSource;
import com.userDemo.model.Goods;

import java.util.ArrayList;
import java.util.List;

public interface IGoodsService {
    @DataSource("read")
    List<Goods> findGoodsBytatus(int status);

    @DataSource("read")
    Goods findGoodsByIdAndStock(int id, int stock);

    @DataSource("read")
    Goods findGoodsById(int id);

    @DataSource("write")
    void add(Goods goods);

    @DataSource("read")
    ArrayList<Goods> findGoodsAll();

    @DataSource("write")
    void Update(Goods goods);
}
