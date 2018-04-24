package cn.e3mall.e3contentinterface;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

public interface ContentCategory {

    List<EasyUITreeNode> list(int parentId);


}
