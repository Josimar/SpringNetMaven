package com.josimas.projectone.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class PrimaryGreetingService implements  GreetingService{
    @Override
    public String sayGreeting() {
        return "Primary: Greeting to see you";
    }
}
