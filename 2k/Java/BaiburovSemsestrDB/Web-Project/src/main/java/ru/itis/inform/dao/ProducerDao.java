package ru.itis.inform.dao;

import ru.itis.inform.models.Producer;

import java.util.LinkedList;

public interface ProducerDao {

    //Добавление продюсера
    boolean addProducer(Producer producer);

    //Получение модели продюсера
    Producer getProducer(int id);

    //Получить список всех продюсерров
    LinkedList<Producer> getProducers();

    //Delete producer
    void deleteProducer(int id);
}
