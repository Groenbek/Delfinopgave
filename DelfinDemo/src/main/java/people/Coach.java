package people;

import java.util.ArrayList;
import mappers.MemberMap;
import mappers.MemberTraining;
import mappers.MembersToComp;
import model.Result;
import model.SwimEvent;
import presentation.ConsoleUI;

public class Coach {

    private MemberTraining memberTrain = new MemberTraining();
    private MemberMap memberMap = new MemberMap();
    private MembersToComp membersToComp = new MembersToComp();

    public void printTeam(ConsoleUI ui) {
        ui.println("Hvilket hold vil du se?\n1) Hold 1\n2) Hold 2");
        int teamViewer = Integer.parseInt(ui.getInput());
        ArrayList<Member> members = memberMap.getMembersInTeam(teamViewer);

        for (Member member : members) {
            ui.println(member.toString());
        }
    }

    public void printEvents(ConsoleUI ui) {
        System.out.println("tis1");
        ArrayList<SwimEvent> se = membersToComp.getSwimEvents();

        System.out.println("tis2");
        if (se != null || se.size() <= 0) {
            ui.println("Oversigt over events:");
            for (SwimEvent swimevent : se) {
                ui.println(swimevent.toString());
            }
        }
        System.out.println("tis3");
    }

    public void updateTrainingResult(ConsoleUI ui) {
        ui.println("Angiv medlemsnummer: ");
        int mId = Integer.parseInt(ui.getInput());
        ui.println("Indtast dato: ");
        int date = Integer.parseInt(ui.getInput());
        ui.println("Indtast tid: ");
        int tid = Integer.parseInt(ui.getInput());
        memberTrain.registerTrainingResult(date, tid, mId);

    }

    public void updateEventResult(ConsoleUI ui) {
          if (membersToComp.getSwimEvents().isEmpty()) {
              ui.println("Der er ikke oprettet nogle stævner");
             createSwimEvent(ui);
          }
          printEvents(ui);
        ui.println("Vælg stævne ID:");
        int seId = Integer.parseInt(ui.getInput());
        if (seId > membersToComp.getSwimEvents().size() || seId < 0) {
            while (seId != 0) {
                ui.println("ID'et findes ikke. Tryk 0 for at oprette nyt stævne.");
                seId = Integer.parseInt(ui.getInput());
            }
            if (seId == 0) {
                createSwimEvent(ui);
                seId = membersToComp.getSwimEvents().size();
            }
        }
        
        ui.println("Angiv medlemsnummer: ");
        int mId = Integer.parseInt(ui.getInput());

        ui.println("Indtast placering: ");
        int sePlacement = Integer.parseInt(ui.getInput());

        ui.println("Angiv disciplinid: ");
        int dId = Integer.parseInt(ui.getInput());
          membersToComp.registerEventResult(seId, mId, dId, sePlacement);
    }

    public void createSwimEvent(ConsoleUI ui) {
        ui.println("Indtast dato for stævne:");
        String date = ui.getInput();
        ui.println("Indtast navn for stævne:");
        String name = ui.getInput();
        membersToComp.registerSwimEvent(date, name);
    }

}
