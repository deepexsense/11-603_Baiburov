package ru.itis.inform.services;

import ru.itis.inform.models.Producer;

import java.util.LinkedList;

//Все это сервисы с управлениями ДАО
public interface ProducerService{
    boolean addProducer(Producer producer);
    Producer getProducer(int id);
    LinkedList<Producer> getAllProducers();
}
