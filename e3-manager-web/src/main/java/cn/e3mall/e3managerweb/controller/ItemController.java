package cn.e3mall.e3managerweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import cn.e3mall.e3managerpojo.pojo.TbItem;
import cn.e3mall.e3managerweb.feign.ItemFeignClient;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemFeignClient itemFeignClient;


    @RequestMapping("/getById/{id}")
    @ResponseBody
    public TbItem getById(@PathVariable Long id) {
//        TbItem item = restTemplate.getForObject("http://MANAGER-SERVICE/item/getById/"+id, TbItem.class);
//        return item;
        TbItem tbItem = itemFeignClient.getById(id);
        return tbItem;
    }
}
