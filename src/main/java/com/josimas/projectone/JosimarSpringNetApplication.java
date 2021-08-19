package com.josimas.projectone;

import com.josimas.projectone.controllers.*;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JosimarSpringNetApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(JosimarSpringNetApplication.class, args);

        GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");

        System.out.println(" ");
        System.out.println("******************************");
        String greeting = greetingController.sayHello();

        System.out.println(greeting);

        System.out.println(" ");
        System.out.println("********** Property **********");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println(" ");
        System.out.println("********** Setter **********");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

        System.out.println(setterInjectedController.getGreeting());

        System.out.println(" ");
        System.out.println("********** Constructor **********");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());

        System.out.println(" ");

        System.out.println(" ");
    }

}
