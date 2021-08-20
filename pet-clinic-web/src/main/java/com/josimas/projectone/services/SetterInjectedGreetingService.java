package com.josimas.projectone.services;

import org.springframework.stereotype.Service;

public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Setter: Greeting to see you";
    }
}
