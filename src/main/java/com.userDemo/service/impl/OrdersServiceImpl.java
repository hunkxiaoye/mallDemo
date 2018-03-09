package com.userDemo.service.impl;

import com.userDemo.dao.IOrdersDao;
import com.userDemo.model.Orders;
import com.userDemo.service.IOrdersService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("OrdersService")
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao orderDao;

    public int add(Orders order) {
        return orderDao.add(order);
    }

    public void update(Orders orders) {
        orderDao.update(orders);
    }

    public void delete(int orderid) {
        orderDao.delete(orderid);
    }

    public ArrayList<Orders> selectlist(int userid) {
        return orderDao.selectlist(userid);
    }

    public Orders select(int orderid) {
        return orderDao.select(orderid);
    }

    public ArrayList<Orders> selectAll() {
        return orderDao.selectAll();
    }

}
