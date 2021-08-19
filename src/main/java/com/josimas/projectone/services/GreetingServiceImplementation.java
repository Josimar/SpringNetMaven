package com.josimas.projectone.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImplementation implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Greeting to see you";
    }
}
