package cn.e3mall.e3managerinterface;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerpojo.pojo.TbContent;

public interface ContentService {

    EasyUIDataGridResult list(long categoryId,int page,int rows);

    E3Result add(TbContent content);

    List<TbContent> getContentList(long cid);
}
