package cn.e3mall.e3managerdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.UnknownServiceException;

import cn.e3mall.e3managerdao.mapper.TbUserMapper;
import cn.e3mall.e3managerpojo.pojo.TbUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class E3ManagerDaoApplicationTests {

	@Autowired
	private TbUserMapper mapper;

	@Test
	public void contextLoads() {
		TbUser tbUser = mapper.selectByPrimaryKey(1L);
		System.out.println("user = "+ tbUser);
	}
}
