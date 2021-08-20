package com.josimas.projectone;

import com.josimas.projectone.controllers.*;
import com.josimas.projectone.services.PrototypeBean;
import com.josimas.projectone.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JosimarSpringNetApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(JosimarSpringNetApplication.class, args);

        GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");

        PetController petController = ctx.getBean("petController", PetController.class);

        System.out.println(" ");
        System.out.println("********** The best pet is **********");
        System.out.println(petController.whichPetIsTheBest());

        System.out.println(" ");

        System.out.println("********** I18n **********");
        System.out.println(i18nController.sayHello());

        System.out.println(" ");

        System.out.println("********** Primary Bean **********");
        System.out.println(greetingController.sayHello());

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

        System.out.println("********** Bean Scopes **********");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println(" ");
    }

}
