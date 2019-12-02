package model;

import people.Formand;
import presentation.ConsoleUI;

public class Program {

    ConsoleUI ui = new ConsoleUI();
    Formand ladyMcGee = new Formand();

    /*  public void startProgram() {
    int choice = 0;
    while (choice != 4) {
    ui.println("---------------------- Delfin Klubben ----------------------");
    ui.println("1) Formand");
    ui.println("2) Kasserer");
    ui.println("3) Træner");
    ui.println("4) Exit");
    
    try {
    choice = Integer.parseInt(ui.getInput());
    if (choice < 1 || choice > 4) {
    throw new NumberFormatException();
    }
    switch (choice) {
    case 1:
    ladyMcGee.insertMember();
    ui.println("Medlem Oprettet");
    break;
    case 2:
    System.out.println("not Implemented");
    break;
    case 3:
    System.out.println("not Implemented");
    break;
    
    }
    
    } catch (NumberFormatException e) {
    ui.println("Vælg mellem menupunkt 1 - 4");
    }
    }
    }*/

}
