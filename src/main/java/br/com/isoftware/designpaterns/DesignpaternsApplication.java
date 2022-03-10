package br.com.isoftware.designpaterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages={"br.com.isoftware.designpaterns.entity"})
public class DesignpaternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignpaternsApplication.class, args);
	}

}
