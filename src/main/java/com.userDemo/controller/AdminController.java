package com.userDemo.controller;

import com.userDemo.common.CookieUtil;
import com.userDemo.model.Goods;
import com.userDemo.model.Orders;
import com.userDemo.model.User;
import com.userDemo.service.IGoodsService;
import com.userDemo.service.IOrdersService;
import com.userDemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;


/**
 * Created by xiaoye on 2018/2/24.
 */
@Controller
public class AdminController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping(value = "/adminindex")
    public String adminindex() {
        return "adminindex";
    }

    @RequestMapping(value = "/adminorderlist")
    public String adminorderlist(Model model) {
        ArrayList<Orders> list = ordersService.selectAll();
        model.addAttribute("list", list);
        return "adminorderlist";
    }

    @RequestMapping(value = "/sendorders")
    public String updateorder(int orderid) {
     Orders orders = ordersService.select(orderid);
     orders.setStatus(3);
     ordersService.update(orders);
        return "redirect:adminorderlist";
    }

    @RequestMapping(value = "/admingoodsist")
    public String admingoodsist(Model model) {
        ArrayList<Goods> goods = goodsService.findGoodsAll();
        model.addAttribute("list", goods);
        return "admingoodsist";
    }

    @RequestMapping(value = "/updateGoodlist")
    public String updateGoodlist(int goodsid,int type, RedirectAttributes atte) {
        Goods model = goodsService.findGoodsById(goodsid);
        if (type == 2) {
            model.setStatus(0);
        } else if (type == 3) {
            model.setStatus(1);
        } else {
            atte.addAttribute("goodsid", goodsid);
            return "redirect:/Goodpage";
        }
        goodsService.Update(model);
        return "redirect:admingoodsist";
    }

    @RequestMapping(value = "/updateGood")
    public String updateGood(Goods goods) {
        goodsService.Update(goods);

        return "redirect:admingoodsist";
    }

    @RequestMapping(value = "/Goodpage")
    public String Goodpage(int goodsid,Model model) {
        if (goodsid!=-10) {
            model.addAttribute("model", goodsService.findGoodsById(goodsid));
            model.addAttribute("isUpdate", true);
        }
        else {
            model.addAttribute("isUpdate", false);
        }
        return "updateGood";
    }

    @RequestMapping("/creatGoods")
    public String addGoods( Goods goods, Model model) {
        model.addAttribute("isUpdate",false);
        goodsService.add(goods);
        return "redirect:admingoodsist";


    }
}