package com.josimas.projectone.controllers;

import com.josimas.projectone.services.GreetingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImplementation());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}