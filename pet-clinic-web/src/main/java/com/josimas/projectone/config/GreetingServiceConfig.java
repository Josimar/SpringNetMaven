package com.josimas.projectone.config;

import com.josimas.pets.PetService;
import com.josimas.pets.PetServiceFactory;
import com.josimas.projectone.datasource.FakeDataSource;
import com.josimas.projectone.repository.EnglishGreetingRepository;
import com.josimas.projectone.repository.EnglishGreetingRepositoryImplementation;
import com.josimas.projectone.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(JosimarSpringConstructorConfig.class)
@ImportResource("classpath:pet-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(JosimarSpringConstructorConfig josimarSpringConstructorConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();

        fakeDataSource.setUsername(josimarSpringConstructorConfig.getUsername());
        fakeDataSource.setPassword(josimarSpringConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(josimarSpringConstructorConfig.getJdbcurl());

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean("petService")
    @Profile({"dog", "default"})
    PetService dogService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile("bird")
    PetService birdService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("bird");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImplementation();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishService i18nEnglishService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishService(englishGreetingRepository);
    }

    @Profile({"PT", "default"})
    @Bean("i18nService")
    I18nPortugueseService i18nPortugueseService(){
        return new I18nPortugueseService();
    }

    @Profile("ES")
    @Bean
    I18nSpanishService i18nService(){
        return new I18nSpanishService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}
