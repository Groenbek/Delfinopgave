package people;

import model.Member;
import mappers.MemberMap;
import mappers.MemberToTeam;
import mappers.MemberTraining;
import presentation.ConsoleUI;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class Chairman {

    private MemberMap memberMap = new MemberMap();
    private MemberToTeam memberToTeam = new MemberToTeam();
    private MemberTraining memberTrain = new MemberTraining();
    private ConsoleUI ui;

    public Chairman(ConsoleUI ui) {
        this.ui = ui;
    }

    //Prompt user for values, creates and returns Member object
    private Member createMember() {
        ui.println("Tast navn: ");
        String name = ui.getInput();
        ui.println("Tast alder: ");
        int age = Integer.parseInt(ui.getInput());
        ui.println("Er svømmeren aktiv eller passiv?");
        String actOrPas = ui.getInput().toLowerCase();
        String competitive;
        if (actOrPas.equals("aktiv")) {
            ui.println("Deltager svømmeren i stævner?");
            competitive = ui.getInput();
        } else {
            competitive = "Nej";
        }
        Member member = new Member(0, name, age, actOrPas, competitive);
        return member;
    }

    //Insert member values into correct database tables using mappers
    public void insertMemberAllTables() {
        Member member = createMember();
        memberMap.insertMember(member);
        int tId = calculateTeamID(member);
        int mId = memberMap.getMemberId();
        int mType = calculatePriceID(member);
        memberToTeam.insertMember(mId, tId, mType, "Betalt");
        if (member.getActOrPas().equals("aktiv")) {
            memberTrain.insertMember(tId, mId, 1, 0);
            memberTrain.insertMember(tId, mId, 2, 0);
            memberTrain.insertMember(tId, mId, 3, 0);
            memberTrain.insertMember(tId, mId, 4, 0);
        }
    }

    //Calculate team ID from member age
    private int calculateTeamID(Member member) {
        if (member.getAge() < 18) {
            return 1;
        }
        return 2;
    }

    //Calculate price from member ActOrPas and age value
    private int calculatePriceID(Member member) {
        if (member.getActOrPas().equals("passiv")) {
            return 1;
        } else if (member.getActOrPas().equals("aktiv") && member.getAge() < 18) {
            return 2;
        } else if (member.getActOrPas().equals("aktiv") && member.getAge() >= 60) {
            return 3;
        }
        return 4;
    }
}