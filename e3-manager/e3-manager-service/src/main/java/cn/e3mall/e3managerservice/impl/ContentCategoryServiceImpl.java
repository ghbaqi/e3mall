package cn.e3mall.e3managerservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerdao.mapper.TbContentCategoryMapper;
import cn.e3mall.e3managerinterface.ContentCategoryService;
import cn.e3mall.e3managerpojo.pojo.TbContentCategory;
import cn.e3mall.e3managerpojo.pojo.TbContentCategoryExample;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper mapper;


    // 按树形结构获取分类
    @Override
    public List<EasyUITreeNode> list(long parentId) {

        ArrayList<EasyUITreeNode> nodes = new ArrayList<>();

        TbContentCategoryExample example = new TbContentCategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbContentCategory> categories = mapper.selectByExample(example);

        if (!categories.isEmpty()) {
            for (TbContentCategory category : categories) {
                EasyUITreeNode node = new EasyUITreeNode();
                node.setId(category.getId());
                node.setText(category.getName());
                node.setState(category.getIsParent() ? "closed" : "open");
                nodes.add(node);
            }
        }
        return nodes;
    }

    /**
     * 创建一个内容分类 节点
     */
    @Override
    public E3Result create(long parentId, String name) {
        TbContentCategory parentCategory = mapper.selectByPrimaryKey(parentId);
        if (parentCategory == null) {
            return E3Result.build(-1, "找不到父节点");
        }

        // 1、接收两个参数：parentId、name
        // 2、向tb_content_category表中插入数据。
        // a)创建一个TbContentCategory对象
        TbContentCategory tbContentCategory = new TbContentCategory();
        // b)补全TbContentCategory对象的属性
        tbContentCategory.setIsParent(false);
        tbContentCategory.setName(name);
        tbContentCategory.setParentId(parentId);
        //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
        tbContentCategory.setSortOrder(1);
        //状态。可选值:1(正常),2(删除)
        tbContentCategory.setStatus(1);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        // c)向tb_content_category表中插入数据
        mapper.insert(tbContentCategory);
        // 3、判断父节点的isparent是否为true，不是true需要改为true。
        if (!parentCategory.getIsParent()) {
            parentCategory.setIsParent(true);
            //更新父节点
            mapper.updateByPrimaryKey(parentCategory);
        }
        // 4、需要主键返回。
        // 5、返回E3Result，其中包装TbContentCategory对象
        return E3Result.ok(tbContentCategory);
    }
}
