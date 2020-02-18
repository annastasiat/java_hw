package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));
                    //new Locale("en"));


    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatStrings(String... strings){
        StringBuilder concatString = new StringBuilder();
        for(String str : strings) {
            concatString.append(str);
        }
        return concatString.toString();
    }

}
