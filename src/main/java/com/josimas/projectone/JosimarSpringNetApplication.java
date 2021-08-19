package com.josimas.projectone;

import com.josimas.projectone.controllers.TaskController;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JosimarSpringNetApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(JosimarSpringNetApplication.class, args);

        TaskController taskController = (TaskController) ctx.getBean("taskController");

        String greeting = taskController.sayHello();

        System.out.println(greeting);

    }

}
