package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Cart;
import com.userDemo.model.Goods;
import com.userDemo.model.OrderDetail;
import com.userDemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping(value = "/orderIndex")
    public String orderIndex(Model model, HttpServletRequest request) throws Exception {
        ArrayList<Goods> goodsList = new ArrayList<>();
        List<Cart> list = cartService.selectCart(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        for (Cart item : list) {
            goodsList.add(goodsService.findGoodsById(item.getGoods_id()));
        }

        model.addAttribute("$goodsList", goodsList);

        return "redirect:/Order";
    }


    public String addOrder(int addressid, HttpServletRequest request) throws Exception {
        List<Cart> list = cartService.selectCart(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        OrderDetail model = new OrderDetail();

        //创建order主订单(3.9 Order表方法创建)
        for (Cart item : list) {
            model.setGoods_id(item.getGoods_id());
            model.setAmount(item.getAmount());
            model.setOrder_id(1);
            orderDetailService.add(model);
        }
        return "redicect:/Order";

    }
}
