package ru.kpfu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.kpfu.utils.DataSourceService;

import javax.sql.DataSource;


@PropertySource("/application.properties")
@Configuration
@ComponentScan(basePackages = {"ru.kpfu.controllers", "ru.kpfu.repositories", "ru.kpfu.utils"})
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;
    @Autowired
    private DataSourceService dataSourceService;
    @Bean
    public DataSource dataSource() {
        return dataSourceService.getDataSource(env.getProperty("jdbc.driver"), env.getProperty("jdbc.url"),
                env.getProperty("jdbc.username"), env.getProperty("jdbc.password"));
    }
}
