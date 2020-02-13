package ua.testing;

import ua.testing.controller.Controller;
import ua.testing.model.Model;
import ua.testing.view.View;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Уепапииииап!" );


        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
