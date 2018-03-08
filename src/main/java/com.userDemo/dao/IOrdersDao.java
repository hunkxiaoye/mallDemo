package com.userDemo.dao;

import com.userDemo.model.OrderDetail;
import com.userDemo.model.Orders;

public interface IOrdersDao {
    int add(Orders order);
}
