package cn.e3mall.e3managerservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.e3managerdao.mapper.TbItemDescMapper;
import cn.e3mall.e3managerdao.mapper.TbItemMapper;
import cn.e3mall.e3managerinterface.ItemService;
import cn.e3mall.e3managerpojo.pojo.TbItem;
import cn.e3mall.e3managerpojo.pojo.TbItemDesc;
import cn.e3mall.e3managerpojo.pojo.TbItemExample;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper descMapper;

    @Override
    public TbItem getById(long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     */
    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> items = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(items);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 添加商品
     */
    @Override
    public E3Result saveItem(TbItem item, String desc) {
        if (item == null) {
            return E3Result.build(0, "添加失败");
        }

        // 1、生成商品id
        long itemId = IDUtils.genItemId();
        // 2、补全TbItem对象的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 3、向商品表插入数据
        itemMapper.insert(item);
        // 4、创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 5、补全TbItemDesc的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 6、向商品描述表插入数据
        descMapper.insert(itemDesc);
        // 7、E3Result.ok()
        return E3Result.ok();

    }
}
