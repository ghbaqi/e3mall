package cn.e3mall.e3managerservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.e3managerdao.mapper.TbItemCatMapper;
import cn.e3mall.e3managerinterface.ItemCatService;
import cn.e3mall.e3managerpojo.pojo.TbItemCat;
import cn.e3mall.e3managerpojo.pojo.TbItemCatExample;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper catMapper;

    // 获取子分类  传入 parentId
    // 一开始传入 0
    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {

        ArrayList<EasyUITreeNode> nodes = new ArrayList<>();

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> cats = catMapper.selectByExample(example);

        if (!cats.isEmpty()) {
            for (TbItemCat cat : cats) {
                EasyUITreeNode node = new EasyUITreeNode();
                node.setId(cat.getId());
                node.setState(cat.getIsParent() ? "closed" : "open");
                node.setText(cat.getName());
                nodes.add(node);
            }
        }


        return nodes;
    }
}
