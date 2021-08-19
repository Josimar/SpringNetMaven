package com.josimas.projectone.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Constructor: Greeting to see you";
    }
}
