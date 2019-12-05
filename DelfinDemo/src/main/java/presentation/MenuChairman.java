package presentation;

import people.Chairman;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MenuChairman implements Menu {

    private ConsoleUI ui;
    private Chairman chairman;

    public MenuChairman(ConsoleUI ui) {
        this.ui = ui;
        chairman = new Chairman(ui);
    }

    //Prompt user for menu options and act on correspondant options
    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 2) {
            ui.println("---------------------------- Delfin Klubben ----------------------------");
            ui.println("1) Registrer ny bruger");
            ui.println("2) Tilbage til hovedmenu");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 2) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        chairman.insertMemberAllTables();
                        //memberMap.insertMember(member);
                        ui.println("Bruger oprettet.");
                        break;
                }
            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 2");
            }
        }
    }
}