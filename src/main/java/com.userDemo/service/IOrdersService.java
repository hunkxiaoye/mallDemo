package com.userDemo.service;

import com.userDemo.common.database.DataSource;
import com.userDemo.model.Orders;

import java.util.ArrayList;

public interface IOrdersService {
    @DataSource("write")
    int add(Orders order);

    @DataSource("write")
    void update(Orders orders);

    @DataSource("write")
    void delete(int orderid);

    @DataSource("read")
    ArrayList<Orders> selectlist(int userid);

    @DataSource("read")
    Orders select(int orderid);

    @DataSource("read")
    ArrayList<Orders> selectAll();
}
