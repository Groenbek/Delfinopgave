package presentation;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MainMenu implements Menu {
    private ConsoleUI ui = new ConsoleUI();
    private Menu activeMenu;

    public MainMenu() {
        startMenu();
    }

    //Prompt user for menu options and act on correspondant options
    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 4) {
            ui.println("---------------------------- Delfin Klubben ----------------------------");
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
                        activeMenu = new MenuChairman(ui);
                        activeMenu.startMenu();
                        break;
                    case 2:
                        activeMenu = new MenuCashier(ui);
                        activeMenu.startMenu();
                        break;
                    case 3:
                        activeMenu = new MenuCoach(ui);
                        activeMenu.startMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 4");
            }
        }
    }
}