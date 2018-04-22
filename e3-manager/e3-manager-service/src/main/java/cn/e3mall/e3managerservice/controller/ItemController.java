package cn.e3mall.e3managerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.e3managerinterface.ItemService;
import cn.e3mall.e3managerpojo.pojo.TbItem;

@Controller
@RequestMapping("/item")
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/getById/{id}")
    public TbItem getById(@PathVariable Long id) {
        logger.info("getById id = " + id);
        TbItem tbItem = itemService.getById(id);
        return tbItem;
    }


    @ResponseBody
    @RequestMapping("/list")
    public EasyUIDataGridResult list(int page,int rows) {
        logger.info("getByPage pageNum = " + page);
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
}
