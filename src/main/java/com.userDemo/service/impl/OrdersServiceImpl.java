package com.userDemo.service.impl;

import com.userDemo.dao.IOrdersDao;
import com.userDemo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao orderDao;
}
