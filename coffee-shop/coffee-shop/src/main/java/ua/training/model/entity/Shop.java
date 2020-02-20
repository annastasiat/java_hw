package ua.training.model.entity;

import ua.training.exception.NoProductLeftException;

import java.util.List;

public interface Shop {
    List<DBCoffeeShop> sortByPriceAndWeight();
    boolean isAvailableAmount(DBCoffeeShop record, int amount);
    void sell(DBCoffeeShop record, int amount) throws NoProductLeftException;
}
