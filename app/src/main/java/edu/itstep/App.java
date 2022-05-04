package edu.itstep;

import edu.itstep.exception.EntityNotFoundException;
import edu.itstep.menu.Menu;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        try {
            menu.init();
        } catch (EntityNotFoundException ex) {
            ex.getMessage();
            System.out.println("Some error is occurred. The app will restart now.");
            menu.init();
        }
    }
}
