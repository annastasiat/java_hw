package ua.training.controller;

import ua.training.model.entity.CoffeeShop;
import ua.training.model.Model;
import ua.training.model.entity.LoadTypes;
import ua.training.view.View;

import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        CoffeeShop shop = model.getCoffeeShop();
        shop.loadProducts(LoadTypes.ORDINARY_LOAD);
        SellCoffee sellCoffee = new SellCoffee(view, shop, sc);
        sellCoffee.workWithCustomer();
    }
}
