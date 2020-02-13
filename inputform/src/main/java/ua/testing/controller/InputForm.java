package ua.testing.controller;

import ua.testing.model.Model;
import ua.testing.model.ModelFileds;
import ua.testing.view.View;

import java.util.Scanner;

public class InputForm {
    private View view;
    private Model model;
    private Scanner sc;

    InputForm(View view, Model model, Scanner sc) {
        this.view = view;
        this.model = model;
        this.sc = sc;
    }

    void inputData() {
        UtilityController uc = new UtilityController(view, sc);

        model.setName(uc.inputStringModelFieldWithScanner(ModelFileds.name.name()));
        model.setSurname(uc.inputStringModelFieldWithScanner(ModelFileds.surname.name()));
        model.setPatronymic(uc.inputStringModelFieldWithScanner(ModelFileds.patronymic.name()));

        model.formPersonalInfo();
        view.printMessage(model.getPersonalInfo());


        model.setLogin(uc.inputStringModelFieldWithScanner(ModelFileds.login.name()));
        model.setComment(uc.inputStringModelFieldWithScanner(ModelFileds.comment.name()));

        model.setHomePhone(uc.inputStringModelFieldWithScanner(ModelFileds.homephone.name()));
        model.setMobilePhone(uc.inputStringModelFieldWithScanner(ModelFileds.mobilephone.name()));
        model.setMobilePhone2(uc.inputStringModelFieldWithScanner(ModelFileds.mobilephone2.name()));
        model.setEmail(uc.inputStringModelFieldWithScanner(ModelFileds.email.name()));
        model.setSkype(uc.inputStringModelFieldWithScanner(ModelFileds.skype.name()));

        model.setAddress(uc.inputAddressWithScanner());
        model.formAddress();

        //model.setNoteCreationDate();
        //model.setLastModificationDate();


    }
}
