package cn.e3mall.e3managerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"cn.e3mall.e3managerdao.mapper"})
public class E3ManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3ManagerServiceApplication.class, args);
	}
}
