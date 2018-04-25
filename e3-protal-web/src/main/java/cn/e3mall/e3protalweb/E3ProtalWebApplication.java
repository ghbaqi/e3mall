package cn.e3mall.e3protalweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class E3ProtalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3ProtalWebApplication.class, args);
	}
}
