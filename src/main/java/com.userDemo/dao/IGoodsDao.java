package com.userDemo.dao;

import com.userDemo.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface IGoodsDao {
    List<Goods> findGoodsBytatus(int status);

    Goods findGoodsByIdAndStock(@Param("id") int id, @Param("stock") int stock);

    Goods findGoodsById(int id);

    void add(Goods goods);

    ArrayList<Goods> findGoodsAll();

    void Update(Goods goods);
}
