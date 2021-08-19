package com.josimas.projectone.controllers;

import com.josimas.projectone.services.GreetingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp(){
        controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceImplementation();
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
