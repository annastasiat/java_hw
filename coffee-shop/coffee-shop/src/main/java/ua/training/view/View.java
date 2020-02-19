package ua.training.view;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.DBCoffeeShop;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    static Locale LOCALE = new Locale("ua", "UA");  //new Locale("en"));
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    LOCALE);


    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatStrings(String... strings) {
        StringBuilder concatString = new StringBuilder();
        for (String str : strings) {
            concatString.append(" ");
            concatString.append(str);
        }
        return concatString.toString();
    }


    public void printCoffeeRecord(DBCoffeeShop record) {
        Coffee coffee = (Coffee) record.getProduct();
        System.out.println(concatStrings(bundle.getString(MessageConstants.ORIGIN), coffee.getOrigin()));
        System.out.println(concatStrings(bundle.getString(MessageConstants.STATE), coffee.getState().toString()));
        System.out.println(concatStrings(bundle.getString(MessageConstants.PRICE),
                Integer.toString(coffee.getPrice()), bundle.getString(MessageConstants.CURRENCY)));
        System.out.println(concatStrings(bundle.getString(MessageConstants.WEIGHT_PER_PIECE), Integer.toString(coffee.getWeightPerPiece())));
        System.out.println(concatStrings(bundle.getString(MessageConstants.AMOUNT), Integer.toString(record.getAmount())));

    }

    public void printCoffeeRecords(List<DBCoffeeShop> records) {
        for (DBCoffeeShop record : records) {
            Coffee coffee = (Coffee) record.getProduct();
            System.out.println(concatStrings(bundle.getString(MessageConstants.ORIGIN), coffee.getOrigin()));
            System.out.println(concatStrings(bundle.getString(MessageConstants.STATE), coffee.getState().toString()));
            System.out.println(concatStrings(bundle.getString(MessageConstants.PRICE),
                    Integer.toString(coffee.getPrice()), bundle.getString(MessageConstants.CURRENCY)));
            System.out.println(concatStrings(bundle.getString(MessageConstants.WEIGHT_PER_PIECE), Integer.toString(coffee.getWeightPerPiece())));
            System.out.println(concatStrings(bundle.getString(MessageConstants.AMOUNT), Integer.toString(record.getAmount())));

            System.out.println(MessageConstants.BLANCK_LINE);
        }
    }

}
