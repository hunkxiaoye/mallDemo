package com.userDemo.service.impl;

import com.userDemo.common.CacheUtils;
import com.userDemo.dao.IGoodsDao;
import com.userDemo.model.Goods;
import com.userDemo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("GoodsService")
public class GoodsServicelmpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;

    public List<Goods> findGoodsBytatus(int status) {
        List<Goods> list = null;
        if (CacheUtils.get("goods", 300) == null) {
            list = goodsDao.findGoodsBytatus(status);
            CacheUtils.set("goods", list, 300);
        } else {
            list = CacheUtils.get("goods", 300);
        }
        return list;
    }

    public Goods findGoodsByIdAndStock(int id, int stock) {
        Goods goods = null;
        if (CacheUtils.get("goods", 600) == null) {
            goods = goodsDao.findGoodsByIdAndStock(id, stock);
            CacheUtils.set("goods", goods, 600);

        } else {
            goods = CacheUtils.get("goods", 600);
        }


        return goods;
    }

    public Goods findGoodsById(int id) {
        Goods goods = null;
        goods = goodsDao.findGoodsById(id);
        return goods;
    }

   public void add(Goods goods){
        goodsDao.add(goods);
   }

   public ArrayList<Goods> findGoodsAll(){
     return  goodsDao.findGoodsAll();
   }

   public void Update(Goods goods){
         goodsDao.Update(goods);
    }
}
