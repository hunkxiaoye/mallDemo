package com.userDemo.controller.Goods;

import com.userDemo.model.Goods;
import com.userDemo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "/index")
    public String GoodsTable(@RequestParam(required = false,defaultValue = "0") int type,Model model)
    {

        //List<Goods> list = goodsService.findGoodsBytatus(type);
           // model.addAttribute("list",list);
        Goods goods =goodsService.findGoodsByIdAndStock(1,3);
        model.addAttribute("list",goods);
        return "index";
    }

}
