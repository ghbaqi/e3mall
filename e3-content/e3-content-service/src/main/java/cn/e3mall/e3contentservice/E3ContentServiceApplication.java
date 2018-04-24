package cn.e3mall.e3contentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"cn.e3mall.e3managerdao.mapper"})
public class E3ContentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3ContentServiceApplication.class, args);
	}
}
