package cn.e3mall.e3managerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.e3managerinterface.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatConntroller {

    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping("/list")
    public List<EasyUITreeNode> list(@RequestParam(defaultValue = "0") long parentId) {
        List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }
}
