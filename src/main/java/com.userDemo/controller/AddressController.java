package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Address;
import com.userDemo.service.IAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Controller
public class AddressController {
    @Autowired
    private IAddressService addressService;


    @RequestMapping(value = "/AddressIndex")
    public String AddressIndex(Model model, HttpServletRequest request) throws Exception {
        int userid = Integer.parseInt(CookieUtil.getLoginInfo(request)[1]);

        model.addAttribute("List", selectList(userid));
        return "AddressIndex";

    }

    @RequestMapping(value = "/AddressList")
    public String AddressList(Model model, HttpServletRequest request) throws Exception {
        int userid = Integer.parseInt(CookieUtil.getLoginInfo(request)[1]);

        model.addAttribute("List", selectList(userid));
        return "order";
    }

    public ArrayList<Address> selectList(int userid) {
        ArrayList<Address> addressList;
        addressList = addressService.findAllByuserid(userid);
        return addressList;
    }

    @RequestMapping(value = "/AddressPage")
    public String AddressPage(Model model, int type, int id) {
        if (type == 1) {
            model.addAttribute("isUpdate", true);
            model.addAttribute("model", addressService.findAllById(id));
        } else {
            model.addAttribute("isUpdate", false);
        }
        return "CreateAddress";
    }

    @RequestMapping(value = "/UpdateAddress")
    public void UpdateAddress(Address address, HttpServletResponse response) throws Exception {
        addressService.Update(address);
        response.sendRedirect("AddressIndex");
        //return "AddressIndex";
    }

    @RequestMapping(value = "/CreateAddress")
    public void CreateAddress(Address address, HttpServletResponse response, HttpServletRequest request) throws Exception {
        address.setUser_id(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        addressService.add(address);
        response.sendRedirect("AddressIndex");
        //return "AddressIndex";
    }

    @RequestMapping(value = "/delAddress")
    public void delAddress(int id, HttpServletResponse response) throws Exception {
        addressService.delete(id);
        response.sendRedirect("AddressIndex");
        //return "AddressIndex";
    }
}
