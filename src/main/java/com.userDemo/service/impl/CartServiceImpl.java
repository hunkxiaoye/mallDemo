package com.userDemo.service.impl;

import com.userDemo.dao.ICartDao;
import com.userDemo.model.Goods;
import com.userDemo.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartDao cartDao;



   public List<Goods> selectCart(int userid){

       return cartDao.selectCart(userid);
   }
   public int addCart(int goodsid,int userid,int amount){
       return cartDao.addCart(goodsid,userid,amount);
   }
   public int deleteCart( int goodsid,int userid){
    return cartDao.deleteCart(goodsid,userid);
   }
}
