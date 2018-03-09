package com.userDemo.service;

import com.userDemo.model.Orders;

import java.util.ArrayList;

public interface IOrdersService {
    int add(Orders order);

    void update(Orders orders);

    void delete(int orderid);

    ArrayList<Orders> selectlist(int userid);

    Orders select(int orderid);

    ArrayList<Orders> selectAll();
}
