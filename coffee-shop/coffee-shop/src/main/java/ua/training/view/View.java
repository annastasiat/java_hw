package ua.training.view;


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

}
