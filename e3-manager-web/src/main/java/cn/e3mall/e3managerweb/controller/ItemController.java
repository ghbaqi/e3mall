package cn.e3mall.e3managerweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
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


    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getByPage(Integer page, Integer rows) {
        EasyUIDataGridResult gridResult = itemFeignClient.getByPage(page, rows);
        return gridResult;
    }


    // 分类查询
    @RequestMapping("/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId) {
        List<EasyUITreeNode> catList = itemFeignClient.getItemCatList(parentId);
        return catList;
    }

    // 保存
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result save(TbItem item,String desc) {
//        String title = item.getTitle();
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("title", title);
//        map.put("price",111L);
//        HashMap<String, Object> map = new HashMap<>();

        E3Result result = itemFeignClient.save(item,desc);
        return result;
    }
}
