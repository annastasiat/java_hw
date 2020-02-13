package ua.testing.controller;

import ua.testing.model.Model;
import ua.testing.view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    private static final String REGEX_BUNDLE_NAME = "regexp";
    private static Locale LOCALE = new Locale("ua", "UA");
    public static final ResourceBundle regexpBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME, LOCALE);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        view.setLocale(LOCALE);

        InputForm inputFormNote = new InputForm(view, model, sc);
        inputFormNote.inputData();


    }


}
