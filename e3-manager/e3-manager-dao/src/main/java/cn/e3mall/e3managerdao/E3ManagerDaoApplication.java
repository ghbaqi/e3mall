package cn.e3mall.e3managerdao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.e3mall.e3managerdao.mapper"})
public class E3ManagerDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3ManagerDaoApplication.class, args);
	}
}
