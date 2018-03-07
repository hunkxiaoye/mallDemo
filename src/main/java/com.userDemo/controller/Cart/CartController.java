package com.userDemo.controller.Cart;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Goods;
import com.userDemo.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ICartService cartService;
    @RequestMapping(value = "/CartIndex")
    public String Cartindex(Model model, HttpServletRequest request) throws Exception {
//        List<Goods> list = cartService.selectCart(Integer.parseInt(CookieUtil.getLoginInfo(request)[2]));
//        model.addAttribute("list",list);
        return "CartIndex";
    }

    @RequestMapping(value = "/addGoods")
    public String addGoods(HttpServletRequest request, int goodsid) throws Exception {
       // cartService.addCart(goodsid, Integer.parseInt(CookieUtil.getLoginInfo(request)[2]), 1);
        return "CartIndex";


    }
    @RequestMapping(value = "/delGoods")
    public String delGoods(HttpServletRequest request ,int goodsid) throws Exception{
       //int msg = cartService.deleteCart(goodsid,Integer.parseInt(CookieUtil.getLoginInfo(request)[2]));
        return "";
    }
}
