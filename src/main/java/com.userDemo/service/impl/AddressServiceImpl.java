package com.userDemo.service.impl;

import com.userDemo.dao.IAddressDao;
import com.userDemo.model.Address;
import com.userDemo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service("addressService")
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private IAddressDao addressDao;

    public ArrayList<Address> findAllByuserid(int userid) {
        return addressDao.findAllByuserid(userid);
    }

    public void add(Address address) {
        addressDao.add(address);
    }

    public void Update(Address address) {
        addressDao.Update(address);
    }

    public void delete(int id) {
        addressDao.delete(id);
    }

    public Address findAllById(int id) {
        return addressDao.findAllById(id);
    }
}
