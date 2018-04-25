package cn.e3mall.e3protalweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import cn.e3mall.e3managerpojo.pojo.TbContent;
import cn.e3mall.e3protalweb.feign.MyFeignClient;

@Controller
public class IndexController {

    @Autowired
    private MyFeignClient client;

    @RequestMapping("/")
    public String index(Model model) {
        List<TbContent> contents = client.showLunBo(89L);  // 89 表示首页轮播图
        System.out.println("contents.size = "+contents.size());
        model.addAttribute("ad1List", contents);
        return "index";
    }
}
