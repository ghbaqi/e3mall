package cn.e3mall.e3eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class E3EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3EurekaServerApplication.class, args);
	}
}
