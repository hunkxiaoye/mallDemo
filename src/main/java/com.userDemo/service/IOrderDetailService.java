package com.userDemo.service;

import com.userDemo.model.OrderDetail;

import java.util.ArrayList;

public interface IOrderDetailService {

    void add(OrderDetail orderDetail);
    ArrayList<OrderDetail> selectlist(int orderid);
    void delect(int orderid);

}
