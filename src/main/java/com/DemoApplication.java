package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);
//



//        EmpController controller= ctx.getBean(EmpController.class);
//
//        controller.printAll("clerk");
	}

}
