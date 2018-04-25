package cn.e3mall.e3managerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerinterface.ContentCategoryService;
import cn.e3mall.e3managerinterface.ContentService;
import cn.e3mall.e3managerpojo.pojo.TbContent;

@Controller
@RequestMapping("/content")
public class ContentController {

    Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentCategoryService categoryService;

    @Autowired
    private ContentService contentService;

    /**
     * 内容分类
     */
    @RequestMapping("/category/list")
    @ResponseBody
    public List<EasyUITreeNode> list(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        logger.info("list pid = " + parentId);
        List<EasyUITreeNode> list = categoryService.list(parentId);
        return list;
    }

    /**
     * 新增一个 内容分类 节点
     * // $.post("/content/category/create",{parentId:node.parentId,name:node.text},
     */
    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    @ResponseBody
    public E3Result create(long parentId, String name) {
        logger.info("create parent = {} , name = {}", parentId, name);
        E3Result e3Result = categoryService.create(parentId, name);
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
        logger.info("contentList categoryId = " + categoryId);
        EasyUIDataGridResult gridResult = contentService.list(categoryId, page, rows);
        return gridResult;
    }

    /**
     * 新增 内容
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result contentSave(@RequestBody TbContent content) {
        logger.info("contentSave content = " + content);
        E3Result e3Result = contentService.add(content);
        return e3Result;
    }

    /**
     * 获取轮播图 内容列表
     */
    @RequestMapping(value = "/showLunBo")
    @ResponseBody
    public List<TbContent> getContentList(@RequestParam  long cid) {
        logger.info("getContentList cid = " + cid);
        List<TbContent> contentList = contentService.getContentList(cid);
        return contentList;
    }
}
