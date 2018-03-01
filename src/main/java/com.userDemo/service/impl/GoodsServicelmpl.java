package com.userDemo.service.impl;

import com.userDemo.dao.IGoodsDao;
import com.userDemo.model.Goods;
import com.userDemo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServicelmpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;
    public List<Goods> findGoodsAll()
    {
        List<Goods> list =goodsDao.findGoodsAll();
        if (list!=null)
        {
            return list;
        }
        return null;
    }


}
