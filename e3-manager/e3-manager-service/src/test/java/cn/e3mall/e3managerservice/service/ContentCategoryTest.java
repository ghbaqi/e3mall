package cn.e3mall.e3managerservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.e3managerinterface.ContentCategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentCategoryTest {


    @Autowired
    private  ContentCategoryService service;

    @Test
    public void test() {
        List<EasyUITreeNode> list = service.list(30L);
        for (EasyUITreeNode easyUITreeNode : list) {
            System.out.println(easyUITreeNode.toString());
        }
    }
}
