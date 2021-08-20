package com.josimas.projectone.services;

import org.springframework.stereotype.Service;

public class PropertyInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Property: Greeting to see you";
    }
}
