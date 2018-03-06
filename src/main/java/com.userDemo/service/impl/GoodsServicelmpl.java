package com.userDemo.service.impl;

import com.userDemo.common.CacheUtils;
import com.userDemo.dao.IGoodsDao;
import com.userDemo.model.Goods;
import com.userDemo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServicelmpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;
    public List<Goods> findGoodsBytatus(int status)
    {
        List<Goods> list =goodsDao.findGoodsBytatus(status);
        if (list!=null)
        {
            return list;
        }
        return null;
    }

    public Goods findGoodsByIdAndStock(int id, int stock) {
        Goods goods = null;
        if (CacheUtils.get("goods") == null) {
            goods = goodsDao.findGoodsByIdAndStock(id, stock);
            CacheUtils.set("goods", goods);

        } else {
            goods = CacheUtils.get("goods");
        }


        return goods;
    }


}
