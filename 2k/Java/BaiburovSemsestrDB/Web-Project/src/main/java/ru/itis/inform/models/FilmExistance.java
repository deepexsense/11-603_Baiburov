package ru.itis.inform.models;

// Модель сущ фильма и его цены
public class FilmExistance {
    private int id;
    private int quantity;
    private int money;


    public FilmExistance(int id, int quantity, int money) {
        this.id = id;
        this.quantity = quantity;
        this.money = money;

    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMoney() {
        return money;
    }
}
