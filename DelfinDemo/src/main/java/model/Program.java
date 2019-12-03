package model;

import people.Chairman;
import presentation.*;

public class Program {

    ConsoleUI ui = new ConsoleUI();
    Chairman ladyMcGee = new Chairman(ui);

    public static void startProgram() {
        new MainMenu();
    }
}
