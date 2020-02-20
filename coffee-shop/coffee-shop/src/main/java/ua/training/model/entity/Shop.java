package ua.training.model.entity;

import ua.training.exception.NoProductLeftException;

import java.util.List;

public interface Shop {
    List<Product> sortByPriceAndWeight();

    boolean isAvailableAmount(Product product, int amount);

    void sell(Product product, int amount) throws NoProductLeftException;
}
