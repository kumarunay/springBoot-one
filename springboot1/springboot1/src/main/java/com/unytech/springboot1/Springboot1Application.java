package com.unytech.springboot1;

import com.unytech.springboot1.model.Laptop;
import com.unytech.springboot1.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Springboot1Application.class, args);

		LaptopService service = context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);

		service.addLaptop(lap);














//		Alien ob1 = context.getBean(Alien.class);
//		ob1.code();
//
////		Alien ob2 = context.getBean(Alien.class);
////		ob2.code();


	}

}
