package com.userDemo.dao;

import com.userDemo.model.OrderDetail;

import java.util.ArrayList;

public interface IOrderDetailDao {
    void add(OrderDetail orderDetail);

    ArrayList<OrderDetail> selectlist(int orderid);

    void delect(int orderid);

}
