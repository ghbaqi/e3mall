package cn.e3mall.e3managerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class E3ManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3ManagerWebApplication.class, args);
	}
}
