package com.userDemo.dao;

import com.userDemo.model.Orders;

import java.util.ArrayList;

public interface IOrdersDao {
    int add(Orders order);

    void update(Orders orders);

    void delete(int id);

    ArrayList<Orders> selectlist(int userid);

    Orders select(int id);

    ArrayList<Orders> selectAll();
}
