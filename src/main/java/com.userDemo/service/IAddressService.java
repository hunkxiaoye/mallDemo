package com.userDemo.service;

import com.userDemo.common.database.DataSource;
import com.userDemo.model.Address;

import java.util.ArrayList;

public interface IAddressService {
    @DataSource("read")
    ArrayList<Address> findAllByuserid(int userid);

    @DataSource("write")
    void add(Address address);

    @DataSource("write")
    void Update(Address address);

    @DataSource("write")
    void delete(int id);

    @DataSource("read")
    Address findAllById(int id);
}
