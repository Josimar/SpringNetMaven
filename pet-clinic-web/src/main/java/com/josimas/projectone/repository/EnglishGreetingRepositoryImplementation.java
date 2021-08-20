package com.josimas.projectone.repository;

public class EnglishGreetingRepositoryImplementation implements EnglishGreetingRepository{

    @Override
    public String getGreeting() {
        return "Hello English";
    }
}
