package cn.e3mall.e3managerservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.e3mall.e3managerinterface.ItemService;
import cn.e3mall.e3managerpojo.pojo.TbItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void test() {
        TbItem item = itemService.getById(536563);
        System.out.println("item = "+item);
    }


    @Test
    public void testSave() {
        TbItem item = itemService.getById(536563);
        item.setBarcode("1111");
        item.setPrice(111L);
        item.setTitle("111");
        itemService.saveItem(item,"111");
    }
}
