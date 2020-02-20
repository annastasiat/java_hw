package ua.training.controller;

import ua.training.exception.*;
import ua.training.model.entity.*;
import ua.training.view.MessageConstants;
import ua.training.view.View;

import java.util.List;
import java.util.Scanner;

public class SellCoffee {
    private View view;
    private CoffeeShop shop;
    private UtilityController uc;

    public SellCoffee(View view, CoffeeShop shop, Scanner sc) {
        this.view = view;
        this.shop = shop;
        this.uc = new UtilityController(sc, view);
    }

    public void showAvailableProducts() {
        List<DBCoffeeShop> coffeeRecords = shop.getCoffeeProductsRecords();
        view.printCoffeeRecords(coffeeRecords);
    }


    public void workWithCustomer() {
        view.printMessage(View.bundle.getString(MessageConstants.GREET_CUSTOMER));
        showAvailableProducts();

        DBCoffeeShop coffeeRecord = getOrderRecord();

        sell(coffeeRecord);

        view.printMessage(View.bundle.getString(MessageConstants.BYE_CUSTOMER));
    }

    private void sell(DBCoffeeShop coffeeRecord) {
        try {
            shop.sell(coffeeRecord, uc.inputIntValue(
                    View.bundle.getString(MessageConstants.INPUT_AMOUNT)));
        } catch (NoProductLeftException e) {
            view.printMessage(View.bundle.getString(MessageConstants.NO_SUCH_PRODUCT_LEFT));
            sell(coffeeRecord);
        }
    }

    private DBCoffeeShop getOrderRecord() {

        String[] order = uc.inputOrderAndMatch(View.bundle.getString(MessageConstants.INPUT_ORDER));

        try {
            return shop.getCoffeeInDB(order[0], CoffeeState.valueOf(order[1].toUpperCase()));
        } catch (NoRecordInDBException e) {
            view.printMessage(View.bundle.getString(MessageConstants.NO_SUCH_PRODUCT));
            return getOrderRecord();
        }
    }
}
