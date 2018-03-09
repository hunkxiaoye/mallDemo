package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.*;
import com.userDemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private IAddressService addressService;

    @RequestMapping(value = "/orderPage")
    public String orderIndex(Model model, HttpServletRequest request) throws Exception {
        ArrayList<Goods> goodsList = new ArrayList<>();
        Integer userid = Integer.parseInt(CookieUtil.getLoginInfo(request)[1]);
        List<Cart> list = cartService.selectCart(userid);
        for (Cart item : list) {
            goodsList.add(goodsService.findGoodsById(item.getGoods_id()));
        }
        ArrayList<Address> addressList;
        addressList = addressService.findAllByuserid(userid);
        model.addAttribute("addressList", addressList);
        model.addAttribute("goodsList", goodsList);

        return "order";
    }

    @RequestMapping(value = "/addOrder")
    public String addOrder(int addressid, HttpServletRequest request, RedirectAttributes atte) throws Exception {
        int userid = Integer.parseInt(CookieUtil.getLoginInfo(request)[1]);
        List<Cart> list = cartService.selectCart(userid);
        OrderDetail model = new OrderDetail();
        Orders orders = new Orders();
        orders.setStatus(0);
        orders.setCreatetime(new Date());
        orders.setAddress_id(addressid);
        orders.setUser_id(userid);
        ordersService.add(orders);
        int orderid = orders.getId();
        for (Cart item : list) {
            model.setGoods_id(item.getGoods_id());
            model.setAmount(item.getAmount());
            model.setOrder_id(orderid);
            orderDetailService.add(model);
        }
        cartService.deleteCartAll(userid);
        atte.addAttribute("orderid", orderid);
        return "redirect:/pay";


    }

    @RequestMapping(value = "/pay")
    public String pay(Model model, Integer orderid) {
        Orders orders = ordersService.select(orderid);
        model.addAttribute("model", orders);
        ArrayList<OrderDetail> list = orderDetailService.selectlist(orders.getId());
        ArrayList<Goods> goodslist = new ArrayList();
        for (OrderDetail item : list) {
            goodslist.add(goodsService.findGoodsById(item.getGoods_id()));
        }
        model.addAttribute("goodslist", goodslist);
        return "pay";
    }

    @RequestMapping(value = "/confirmpay")
    public String confirmpay(Orders orders) {

        orders.setStatus(1);//支付成功
        ordersService.update(orders);
        return "redirect:/orderslist";
    }

    @RequestMapping(value = "/deleteorder")
    public String deleteorder(int orderid) {
        Orders orders = ordersService.select(orderid);
        orders.setStatus(2);//取消订单
        ordersService.update(orders);
        return "redirect:/orderslist";
    }

    @RequestMapping(value = "/orderslist")
    public String orderslist(HttpServletRequest request, Model model) throws Exception {
        ArrayList<Orders> list = ordersService.selectlist(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        model.addAttribute("list", list);
        return "myorder";
    }

    @RequestMapping(value = "/orderdetail")
    public String orderdetail(Integer orderid, Model model) {
        Orders orders = ordersService.select(orderid);
        model.addAttribute("model", orders);
        ArrayList<OrderDetail> list = orderDetailService.selectlist(orders.getId());
        ArrayList<Goods> goodslist = new ArrayList();
        for (OrderDetail item : list) {
            goodslist.add(goodsService.findGoodsById(item.getGoods_id()));
        }
        model.addAttribute("goodslist", goodslist);
        return "orderdetail";
    }
}

