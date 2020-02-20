package ua.training.controller;

import ua.training.view.MessageConstants;
import ua.training.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityController {
    private Scanner scanner;
    private View view;

    public UtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    String[] inputOrderAndMatch(String message) {
        view.printMessage(message);
        Pattern orderPattern = Pattern.compile(View.bundle.getString(MessageConstants.ORDER_REGEX));
        Matcher matcher;

        while (!(scanner.hasNextLine() && (matcher = orderPattern.matcher(scanner.nextLine())).matches())) {
            view.printMessage(View.bundle.getString(MessageConstants.WRONG_INPUT));
        }

        return new String[]{matcher.group(1), matcher.group(2)};
    }

    public int inputIntValue(String message) {
        view.printMessage(message);
        while (!scanner.hasNextInt()) {
            view.printMessage(MessageConstants.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}

