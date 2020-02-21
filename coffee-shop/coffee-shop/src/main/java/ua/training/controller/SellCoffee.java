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
        List<Product> coffeeProducts = shop.getCoffeeProducts();
        printCoffeeProducts(coffeeProducts);
    }


    public void workWithCustomer() {
        view.printMessage(View.bundle.getString(MessageConstants.GREET_CUSTOMER));
        showAvailableProducts();

        Product coffeeRecord = getOrderRecord();

        sell(coffeeRecord);

        showAvailableProducts();

        view.printMessage(View.bundle.getString(MessageConstants.BYE_CUSTOMER));
    }

    private void sell(Product coffeeRecord) {
        try {
            shop.sell(coffeeRecord, uc.inputIntValue(
                    View.bundle.getString(MessageConstants.INPUT_AMOUNT)));
        } catch (NoProductLeftException e) {
            view.printMessage(View.bundle.getString(MessageConstants.NO_SUCH_PRODUCT_LEFT));
            sell(coffeeRecord);
        }
    }

    private Product getOrderRecord() {

        String[] order = uc.inputOrderAndMatch(View.bundle.getString(MessageConstants.INPUT_ORDER));

        try {
            return shop.getCoffee(order[0], CoffeeState.valueOf(order[1].toUpperCase()));
        } catch (NoProductExistException e) {
            view.printMessage(View.bundle.getString(MessageConstants.NO_SUCH_PRODUCT));
            return getOrderRecord();
        }
    }

    public void printCoffeeProducts(List<Product> products) {
        for (Product product : products) {
            Coffee coffee = (Coffee) product;
            view.printMessage(view.concatStrings(View.bundle.getString(MessageConstants.ORIGIN), coffee.getOrigin()));
            view.printMessage(view.concatStrings(View.bundle.getString(MessageConstants.STATE), coffee.getState().toString()));
            view.printMessage(view.concatStrings(View.bundle.getString(MessageConstants.PRICE),
                    String.format("%.2f", coffee.getPriceDouble()), View.bundle.getString(MessageConstants.CURRENCY)));
            view.printMessage(view.concatStrings(View.bundle.getString(MessageConstants.WEIGHT_PER_PIECE), Integer.toString(coffee.getWeightPerPiece())));
            view.printMessage(view.concatStrings(View.bundle.getString(MessageConstants.AMOUNT), Integer.toString(coffee.getAmount())));

            view.printMessage(MessageConstants.BLANCK_LINE);
        }
    }
}
