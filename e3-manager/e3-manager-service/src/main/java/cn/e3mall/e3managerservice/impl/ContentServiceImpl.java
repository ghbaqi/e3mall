package cn.e3mall.e3managerservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerdao.mapper.TbContentMapper;
import cn.e3mall.e3managerinterface.ContentService;
import cn.e3mall.e3managerpojo.pojo.TbContent;
import cn.e3mall.e3managerpojo.pojo.TbContentExample;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper mapper;

    @Override
    public EasyUIDataGridResult list(long categoryId, int page, int rows) {

        PageHelper.startPage(page, rows);
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<TbContent> contents = mapper.selectByExample(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(contents);

        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        gridResult.setRows(contents);
        gridResult.setTotal(pageInfo.getTotal());

        return gridResult;
    }

    /**
     * 添加一个 content
     */
    @Override
    public E3Result add(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        mapper.insert(content);
        return E3Result.ok();
    }

    @Override
    public List<TbContent> getContentList(long cid) {
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(cid);
        List<TbContent> tbContents = mapper.selectByExampleWithBLOBs(example);
        return tbContents;
    }
}
