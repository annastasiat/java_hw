package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Model;
import ua.training.view.View;

public class App
{
    public static void main( String[] args )
    {

        System.out.println( "Привіт" );

        new Controller(new View(), new Model()).processUser();
    }
}
