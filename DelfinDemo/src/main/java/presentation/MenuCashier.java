package presentation;

import people.Cashier;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MenuCashier implements Menu {

    private ConsoleUI ui;
    private Cashier cash;

    public MenuCashier(ConsoleUI ui) {
        this.ui = ui;
        cash = new Cashier();
    }

    //Prompt user for menu options and act on correspondant options
    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 3) {
            ui.println("---------------------------- Delfin Klubben ----------------------------");
            ui.println("1) Se restance");
            ui.println("2) Sæt medlem i restance");
            ui.println("3) Tilbage til hovedmenu");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 3) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        cash.viewRestance(ui);
                        break;
                    case 2:
                        cash.updateRestance(ui);
                        ui.println("Restance opdateret");
                        break;
                }
            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 3");
            }
        }
    }
}