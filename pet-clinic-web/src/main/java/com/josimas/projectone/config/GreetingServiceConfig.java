package com.josimas.projectone.config;

import com.josimas.projectone.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishService i18nEnglishService(){
        return new I18nEnglishService();
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
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
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
