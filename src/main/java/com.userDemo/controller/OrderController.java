package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Cart;
import com.userDemo.model.Goods;
import com.userDemo.service.IAddressService;
import com.userDemo.service.ICartService;
import com.userDemo.service.IGoodsService;
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
    @RequestMapping(value = "/addOrder")
    public String addOrder(Model model, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        ArrayList<Goods> goodsList = new ArrayList<>();
        List<Cart> list = cartService.selectCart(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        for (Cart item : list) {
            goodsList.add(goodsService.findGoodsById(item.getGoods_id()));
        }

        model.addAttribute("list", goodsList);

        return "Order";
    }
}
