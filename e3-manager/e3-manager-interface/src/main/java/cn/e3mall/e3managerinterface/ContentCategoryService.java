package cn.e3mall.e3managerinterface;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;

public interface ContentCategoryService {

    List<EasyUITreeNode> list(long parentId);

    E3Result create(long parentId,String name);
}
