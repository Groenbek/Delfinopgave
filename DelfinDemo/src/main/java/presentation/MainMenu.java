package presentation;

public class MainMenu implements Menu {

    //Menu activeMenu = new MainMenu();
    ConsoleUI ui = new ConsoleUI();
    MenuController mc = new MenuController();
    Menu activeMenu;

    public MainMenu() {
        startMenu();
    }

    @Override
    public void startMenu() {
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
