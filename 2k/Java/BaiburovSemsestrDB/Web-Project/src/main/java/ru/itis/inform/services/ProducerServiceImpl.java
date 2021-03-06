package ru.itis.inform.services;

import ru.itis.inform.dao.ProducerDao;
import ru.itis.inform.dao.ProducerDaoImpl;
import ru.itis.inform.models.Producer;

import java.util.LinkedList;

public class ProducerServiceImpl implements ProducerService {
    private ProducerDao producerDao;

    public ProducerServiceImpl() {
        this.producerDao = new ProducerDaoImpl();
    }

    public boolean addProducer(Producer producer) {
        return producerDao.addProducer(producer);
    }

    public Producer getProducer(int id) {
        return producerDao.getProducer(id);
    }

    public LinkedList<Producer> getAllProducers() {
        return producerDao.getProducers();
    }
}
