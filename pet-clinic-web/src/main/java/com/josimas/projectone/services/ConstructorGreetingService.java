package com.josimas.projectone.services;

public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Constructor: Greeting to see you";
    }
}
