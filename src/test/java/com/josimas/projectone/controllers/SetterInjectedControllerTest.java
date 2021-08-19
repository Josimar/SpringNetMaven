package com.josimas.projectone.controllers;

import com.josimas.projectone.services.GreetingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new GreetingServiceImplementation());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}