package ru.kpfu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackages = {"ru.kpfu.controllers", "ru.kpfu.utils"})
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

}
