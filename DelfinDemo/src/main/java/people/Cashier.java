package people;

import java.util.HashMap;
import mappers.MemberToTeam;
import presentation.ConsoleUI;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class Cashier {

    private MemberToTeam memetoteam = new MemberToTeam();

    //Print all member ID with correspondant haspaid value
    public void viewRestance(ConsoleUI ui) {
        HashMap<Integer, String> mashHap = new MemberToTeam().getRestance();
        for (Integer name : mashHap.keySet()) {
            String key = name.toString();
            String value = mashHap.get(name).toString();
            ui.println("MedlemID: " + key + value);
        }
    }

    //Prompt user for values, uses values as argument in method from mappers.MemberToTeam
    public void updateRestance(ConsoleUI ui) {
        ui.println("Angiv bruger id: ");
        int dis = Integer.parseInt(ui.getInput());
        ui.println("Angiv brugeren som 'betalt' eller 'ikke-betalt'");
        String dat = ui.getInput();
        memetoteam.updateRestance(dis, dat);
    }
}