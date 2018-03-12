package com.userDemo.service;

import com.userDemo.common.database.DataSource;
import com.userDemo.model.OrderDetail;

import java.util.ArrayList;

public interface IOrderDetailService {
    @DataSource("write")
    void add(OrderDetail orderDetail);

    @DataSource("read")
    ArrayList<OrderDetail> selectlist(int orderid);

    @DataSource("write")
    void delect(int orderid);

}
