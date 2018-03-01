package com.userDemo.controller.Goods;

import com.userDemo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/Goods/GoodsList")
    public String GoodsList(Map<String,Object> map)
    {
        map.put("Goodslist",goodsService.findGoodsAll());
        return "/Goods/GoodsList";
    }

}
