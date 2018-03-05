package ru.kpfu.springwebmvc.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getHello(){
        return "Hello";
    }
}
