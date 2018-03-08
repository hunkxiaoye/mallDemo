package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Cart;
import com.userDemo.model.Goods;
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
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "/CartIndex")
    public String Cartindex(Model model, HttpServletRequest request) throws Exception {

        ArrayList<Goods> goodsList = new ArrayList<>();
        List<Cart> list = cartService.selectCart(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        for (Cart item : list) {
            goodsList.add(goodsService.findGoodsById(item.getGoods_id()));
        }
        model.addAttribute("list", goodsList);
        return "CartIndex";
    }

    @RequestMapping(value = "/addGoods")
    public String addGoods(HttpServletRequest request, HttpServletResponse response, int goodsid) throws Exception {
        //String s =CookieUtil.getLoginInfo(request)[1];
        Cart model = new Cart();
        model.setUser_id(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        model.setGoods_id(goodsid);
        model.setAmount(1);
        cartService.add(model);
        response.sendRedirect("CartIndex");
        return "/CartIndex";


    }

    @RequestMapping(value = "/delGoods")
    public String delGoods(HttpServletRequest request, HttpServletResponse response, int goodsid) throws Exception {
        Cart cart = new Cart();
        cart.setGoods_id(goodsid);
        cart.setUser_id(Integer.parseInt(CookieUtil.getLoginInfo(request)[1]));
        cartService.deleteCart(cart);
        response.sendRedirect("CartIndex");
        return "/CartIndex";
    }
}
