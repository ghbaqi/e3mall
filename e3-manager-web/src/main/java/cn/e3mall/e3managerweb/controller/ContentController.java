package cn.e3mall.e3managerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerpojo.pojo.TbContent;
import cn.e3mall.e3managerweb.feign.ItemFeignClient;

// TODO 内容分类删除  更新    ， 内容 编辑 删除
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ItemFeignClient client;

    /**
     * 内容分类
     */
    @RequestMapping("/category/list")
    @ResponseBody
    public List<EasyUITreeNode> list(@RequestParam(name = "id",defaultValue = "0") long parentId) {
        List<EasyUITreeNode>  catList = client.getContentCatList(parentId);
        return catList;
    }


    /**
     * 新增一个 内容分类 节点
     * // $.post("/content/category/create",{parentId:node.parentId,name:node.text},
     */
    @RequestMapping(value = "/category/create",method = RequestMethod.POST)
    @ResponseBody
    public E3Result create( long parentId,String name) {
        E3Result e3Result = client.create(parentId,name);
        return e3Result;
    }


    /**
     * 查询 内容列表
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult contentList(@RequestParam("categoryId") long categoryId,
                                            @RequestParam(name = "page", defaultValue = "1") int page,
                                            @RequestParam(name = "rows", defaultValue = "10") int rows) {
        EasyUIDataGridResult gridResult = client.getContentList(categoryId, page, rows);
        return gridResult;
    }

    /**
     * 增加 内容
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result contentSave(TbContent content) {
        E3Result result = client.saveContent(content);
        return result;
    }



}
