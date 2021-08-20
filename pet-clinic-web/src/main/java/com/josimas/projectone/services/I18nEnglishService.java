package com.josimas.projectone.services;

import com.josimas.projectone.repository.EnglishGreetingRepository;

public class I18nEnglishService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello English";
    }
}
