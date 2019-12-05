package presentation;

import people.Coach;
import presentation.ConsoleUI;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MenuCoach implements Menu {

    private ConsoleUI ui;
    private Coach coach = new Coach();

    public MenuCoach(ConsoleUI ui) {
        this.ui = ui;
    }

    //Prompt user for menu options and act on correspondant options
    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 5) {
            ui.println("---------------------------- Delfin Klubben ----------------------------");
            ui.println("1) Vis holdliste");
            ui.println("2) Registrer træningsresultat");
            ui.println("3) Registrer konkurrenceresultat");
            ui.println("4) Se top 5");
            ui.println("5) Tilbage til hovedmenu");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 5) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        coach.printTeam(ui);
                        break;
                    case 2:
                        coach.updateTrainingResult(ui);
                        ui.println("Resultat registreret.");
                        break;
                    case 3:
                        coach.updateEventResult(ui);
                        ui.println("Resultat registreret.");
                        break;
                    case 4:
                        coach.topFive(ui);
                        ui.println("Medlem indastet i stævne.");
                }
            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 5");
            }
        }
    }
}