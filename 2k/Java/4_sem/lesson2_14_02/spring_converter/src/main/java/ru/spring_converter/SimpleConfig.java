package ru.spring_converter;

import org.springframework.context.annotation.*;



@Configuration
public class SimpleConfig {

   @Bean 
   public Conventer conventer(){
      return new Conventer();
   }
}
