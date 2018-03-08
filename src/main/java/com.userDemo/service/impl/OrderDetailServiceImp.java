package com.userDemo.service.impl;

import com.userDemo.dao.IOrderDetailDao;
import com.userDemo.model.OrderDetail;
import com.userDemo.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "orderDetailService")
public class OrderDetailServiceImp implements IOrderDetailService {
    @Autowired
    private IOrderDetailDao orderDetailDao;

    public void add(OrderDetail orderDetail) {
        orderDetailDao.add(orderDetail);
    }

    public ArrayList<OrderDetail> selectlist(int orderid) {
        return orderDetailDao.selectlist(orderid);
    }

    public void delect(int orderid) {
        orderDetailDao.delect(orderid);
    }
}
