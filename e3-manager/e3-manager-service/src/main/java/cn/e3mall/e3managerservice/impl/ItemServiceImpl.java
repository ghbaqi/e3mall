package cn.e3mall.e3managerservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.e3managerdao.mapper.TbItemMapper;
import cn.e3mall.e3managerinterface.ItemService;
import cn.e3mall.e3managerpojo.pojo.TbItem;
import cn.e3mall.e3managerpojo.pojo.TbItemExample;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getById(long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     */
    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page,rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> items = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(items);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
