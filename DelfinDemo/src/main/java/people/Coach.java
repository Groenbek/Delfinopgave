package people;

import java.util.ArrayList;
import java.util.Collections;
import mappers.MemberMap;
import mappers.MemberTraining;
import mappers.MembersToComp;
import model.CompScore;
import model.Result;
import model.SwimEvent;
import presentation.ConsoleUI;
import presentation.RestultComparator;

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
        ArrayList<SwimEvent> se = membersToComp.getSwimEvents();

        if (se != null || se.size() <= 0) {
            ui.println("Oversigt over events:");
            for (SwimEvent swimevent : se) {
                ui.println(swimevent.toString());
            }
        }
    }

    public void updateTrainingResult(ConsoleUI ui) {
        ui.println("Angiv disciplin: \n1) Crawl\n2) Rygsvømning\n3) Brystsvømning\n4) Butterfly");
        int dis = Integer.parseInt(ui.getInput());
        ui.println("Angiv medlemsnummer: ");
        int mId = Integer.parseInt(ui.getInput());
        ui.println("Indtast dato: ");
        int date = Integer.parseInt(ui.getInput());
        ui.println("Indtast tid: ");
        int tid = Integer.parseInt(ui.getInput());
        memberTrain.registerTrainingResult(dis, date, tid, mId);

    }

    private void insertMemberToEvent(ConsoleUI ui, int disc) {
        if (membersToComp.getSwimEvents().isEmpty()) {
            ui.println("Der er ikke oprettet nogle stævner");
            createSwimEvent(ui);
        }
        ui.println("\n--- Udtag medlem til stævne ---");
        printEvents(ui);
        ui.println("Vælg stævne ID, eller tryk '0' for at oprette stævne:");
        int seId = Integer.parseInt(ui.getInput());
        if (seId > membersToComp.getSwimEvents().size() || seId <= 0) {
            while (seId != 0) {
                ui.println("ID'et findes ikke. Tryk 0 for at oprette nyt stævne.");
                seId = Integer.parseInt(ui.getInput());
            }
            if (seId == 0) {
                createSwimEvent(ui);
                seId = membersToComp.getSwimEvents().size();
            }
        }

        ui.println("Angiv medlemsnummer, for at indsætte medlem i det nye stævne: ");
        int mId = Integer.parseInt(ui.getInput());
        int sePlacement = 0;
        membersToComp.registerEventResult(seId, mId, disc, sePlacement);
    }

    public void updateEventResult(ConsoleUI ui) {
        ArrayList<CompScore> scores = membersToComp.getAllMemberAndScores();
        for (CompScore elm : scores) {
            ui.println(elm.toString());
        }
        ui.println("Indtast medlemsnummer: ");
        int mId = Integer.parseInt(ui.getInput());
        ui.println("Vælg disciplin:\n1) Crawl\n2) Rygsvømning\n3) Brystsvømning\n4) Butterfly");
        int choice = Integer.parseInt(ui.getInput());
        ui.println("Indtast placering: ");
        int placement = Integer.parseInt(ui.getInput());
        membersToComp.updateEventResult(placement, mId, choice);
    }

    private void createSwimEvent(ConsoleUI ui) {
        ui.println("Indtast dato for nyt stævne:");
        String date = ui.getInput();
        ui.println("Indtast navn for nyt stævne:");
        String name = ui.getInput();
        membersToComp.registerSwimEvent(date, name);
    }

    public void topFive(ConsoleUI ui) {
        ui.println("Vælg disciplin til top 5:\n1) Crawl\n2) Rygsvømning\n3) Brystsvømning\n4) Butterfly");
        int choice = Integer.parseInt(ui.getInput());
        ArrayList<Result> allResults = memberTrain.getResults(choice);
        Collections.sort(allResults, new RestultComparator());
        ui.println("TOP 5: ");
        if (allResults.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                if (allResults.get(i).getTime() > 0) {
                    ui.println(allResults.get(i).toString());
                }

            }
        } else {
            for (Result elm : allResults) {
                if (elm.getTime() > 0) {
                    ui.println(elm.toString());
                }

            }
        }
        ui.println("1) Registrer medlem til stævne\n2) Tilbage til menu");
        int oneOrTwo = Integer.parseInt(ui.getInput());
        if (oneOrTwo == 1) {
            insertMemberToEvent(ui, choice);
        }

    }

}
