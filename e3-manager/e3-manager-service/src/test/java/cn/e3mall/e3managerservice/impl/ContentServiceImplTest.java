package cn.e3mall.e3managerservice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.e3managerinterface.ContentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceImplTest {

    @Autowired
    private ContentService service;

    @Test
    public void list() {
        EasyUIDataGridResult gridResult = service.list(89L, 1, 10);
        System.out.println("total = "+gridResult.getTotal());
    }

    @Test
    public void add() {
    }
}