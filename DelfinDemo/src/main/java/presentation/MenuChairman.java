package presentation;

import mappers.MemberMap;
import people.Member;

public class MenuChairman implements Menu {

    private ConsoleUI ui;
    private MemberMap memberMap = new MemberMap();

    public MenuChairman(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 2) {
            ui.println("---------------------- Delfin Klubben ----------------------");
            ui.println("1) Registrer ny bruger");
            ui.println("2) Tilbage til hovedmenu");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 2) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        Member member = createMember();
                        memberMap.insertMember(member);
                        ui.println("Bruger oprettet.");
                        break;
                }

            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 4");
            }
        }
    }

    private Member createMember() {
        ui.println("Tast navn: ");
        String name = ui.getInput();
        ui.println("Tast alder: ");
        int age = Integer.parseInt(ui.getInput());
        ui.println("Er svømmeren aktiv eller passiv?");
        String actOrPas = ui.getInput();
        ui.println("Deltager svømmeren i stævner?");
        String competitive = ui.getInput();
        Member member = new Member(name, age, actOrPas, competitive);
        return member;
    }

    private int calculateTeamID(Member member) {
        if (member.getAge() < 18) {
            return 1;
        }
        return 2;
    }

    private int calculatePriceID(Member member) {
        if (member.getActOrPas().equals("passiv")) {
            return 1;
        } else if (member.getActOrPas().equals("aktiv") && member.getAge() <= 18) {
            return 2;
        } else if (member.getActOrPas().equals("aktiv") && member.getAge() <= 60) {
            return 3;
        }
        return 4;
    }
}
