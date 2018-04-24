package cn.e3mall.e3managerinterface;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.e3managerpojo.pojo.TbItem;

public interface ItemService {

    TbItem getById(long id);

    EasyUIDataGridResult getItemList(int page, int rows);

    E3Result saveItem(TbItem item, String desc);


}
