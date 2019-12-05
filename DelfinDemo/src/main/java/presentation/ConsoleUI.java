package presentation;

import java.util.Scanner;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class ConsoleUI {

    Scanner input = new Scanner(System.in);
    
    //get and return input from user
    public String getInput() {
        return input.nextLine();
    }
    
    //print message to user
    public void println(String msg) {
        System.out.println(msg);
    }
}