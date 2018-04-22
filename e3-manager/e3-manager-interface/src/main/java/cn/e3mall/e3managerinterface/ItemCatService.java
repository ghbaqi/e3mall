package cn.e3mall.e3managerinterface;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

public interface ItemCatService {

    List<EasyUITreeNode> getCatList(long parentId);
}
