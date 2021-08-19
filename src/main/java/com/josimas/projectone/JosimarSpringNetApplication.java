package com.josimas.projectone;

import com.josimas.projectone.controllers.GreetingController;
import com.josimas.projectone.controllers.TaskController;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JosimarSpringNetApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(JosimarSpringNetApplication.class, args);

        GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");

        String greeting = greetingController.sayHello();

        System.out.println(greeting);

    }

}
