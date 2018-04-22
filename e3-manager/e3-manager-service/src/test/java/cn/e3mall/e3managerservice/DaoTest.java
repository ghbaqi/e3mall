package cn.e3mall.e3managerservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import cn.e3mall.e3managerdao.mapper.TbItemMapper;
import cn.e3mall.e3managerpojo.pojo.TbItem;
import cn.e3mall.e3managerpojo.pojo.TbItemExample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private TbItemMapper itemMapper;

    @Test
    public void test() {
        TbItem tbItem = itemMapper.selectByPrimaryKey(832739L);
        System.out.println("item = "+tbItem);
    }


    @Test
    public void test01() {
        PageHelper.startPage(1,5);
        TbItemExample example = new TbItemExample();
        List<TbItem> items = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        System.out.println("total = "+pageInfo.getTotal());
    }
}
