package presentation;

import java.util.ArrayList;
import mappers.MemberMap;
import mappers.MemberTraining;
import model.Result;
import people.Member;

public class MenuCoach implements Menu {

    private ConsoleUI ui;
    private MemberTraining memberTrain = new MemberTraining();
    private MemberMap memberMap = new MemberMap();
    private ArrayList<Result> resArray;

    public MenuCoach(ConsoleUI ui) {
        this.ui = ui;
    }

    @Override
    public void startMenu() {
        int choice = 0;
        while (choice != 2) {
            ui.println("---------------------- Delfin Klubben ----------------------");
            ui.println("1) Vis holdliste");
            ui.println("2) Registrer træningsresultat yoink");
            ui.println("3) Tilbage til hovedmenu");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 2) {
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        printTeam();
                        break;
                    case 2:
                        
                        
                        break;
                }

            } catch (NumberFormatException e) {
                ui.println("Vælg mellem menupunkt 1 - 2");
            }
        }
    }
    private void printTeam() {
        ui.println("Hvilket hold vil du se?\n1) Hold 1\n2) Hold 2");
        int teamViewer = Integer.parseInt(ui.getInput());
//        resArray = memberTrain.getResults(teamViewer);
        ArrayList<Member> members = memberMap.getMembersInTeam(teamViewer);
        
        for (Member member: members) {
            ui.println(member.toString());
        }
    }
//    private void top5() {
//        ui.println("Hvilket hold vil du se?\n1) Hold 1\n2) Hold 2");
//        int teamViewer = Integer.parseInt(ui.getInput());
//        ui.println("Hvilken disciplin vil du se?\n1) Crawl\n2) Rygcrawl\n3) Brystsvømning\n4) Butterfly");
//        int discViewer = Integer.parseInt(ui.getInput());
//        resArray = memberTrain.getResults(discViewer, teamViewer);
//    }

}