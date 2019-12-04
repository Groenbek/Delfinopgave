package people;

import java.util.ArrayList;
import mappers.MemberMap;
import mappers.MemberTraining;
import model.Result;
import presentation.ConsoleUI;

public class Coach {

    private MemberTraining memberTrain = new MemberTraining();
    private MemberMap memberMap = new MemberMap();

    public void printTeam(ConsoleUI ui) {
        ui.println("Hvilket hold vil du se?\n1) Hold 1\n2) Hold 2");
        int teamViewer = Integer.parseInt(ui.getInput());
        ArrayList<Member> members = memberMap.getMembersInTeam(teamViewer);

        for (Member member : members) {
            ui.println(member.toString());
        }
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
}
