package cn.e3mall.e3contentservice.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.e3mall.e3managerdao.mapper.TbContentCategoryMapper;
import cn.e3mall.e3managerpojo.pojo.TbContentCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private TbContentCategoryMapper mapper;

    @Test
    public void test() {
        TbContentCategory contentCategory = mapper.selectByPrimaryKey(30L);
        System.out.println("contentCategory = "+contentCategory);

    }
}
