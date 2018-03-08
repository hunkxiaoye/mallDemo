package com.userDemo.dao;

import com.userDemo.model.Address;

import java.util.ArrayList;
import java.util.List;

public interface IAddressDao {
    ArrayList<Address> findAllByuserid(int userid);

    void add(Address address);

    void Update(Address address);

    void delete(int id);

    Address findAllById(int id);
}
