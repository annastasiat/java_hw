package ua.testing.controller;

import ua.testing.model.Address;
import ua.testing.model.ModelFileds;
import ua.testing.view.View;

import java.util.Scanner;

public class UtilityController {
    private Scanner sc;
    private View view;

    public UtilityController(View view, Scanner sc) {
        this.sc = sc;
        this.view = view;
    }

    String inputStringValueWithScanner(String message, String regexp) {
        String res;
        view.printEnterMessage();
        view.printMessage(message);
        while (!(sc.hasNext() && (res = sc.next()).matches(regexp))) {
            view.printWrongInputMessage();
        }
        return res;
    }

    String inputStringModelFieldWithScanner(String modelField) {
        String res;
        String regexp = Controller.regexpBundle.getString(modelField);
        view.printEnterMessage();
        view.printMessage(View.messageBundle.getString(modelField));
        while (!(sc.hasNextLine() && (res = sc.nextLine()).matches(regexp))) {
            view.printWrongInputMessage();
        }
        return res;
    }

    Address inputAddressWithScanner() {
        Address address = new Address();

        address.setCity(inputStringModelFieldWithScanner(ModelFileds.city.name()));
        address.setIndex(inputStringModelFieldWithScanner(ModelFileds.index.name()));
        address.setStreet(inputStringModelFieldWithScanner(ModelFileds.street.name()));
        address.setHouse(inputStringModelFieldWithScanner(ModelFileds.house.name()));
        address.setApartment(inputStringModelFieldWithScanner(ModelFileds.apartment.name()));

        return address;
    }
}
