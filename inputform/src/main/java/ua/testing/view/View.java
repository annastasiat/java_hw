package ua.testing.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    static String MESSAGE_PROPERTIES = "message";
    public static ResourceBundle messageBundle;

    public void setLocale(Locale locale) {
        messageBundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES, locale);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWrongInputMessage() {
        System.out.println(messageBundle.getString(MessageConstants.WRONG_INPUT_FORMAT));
    }

    public void printEnterMessage() {
        System.out.print(messageBundle.getString(MessageConstants.ENTER));
    }
}
