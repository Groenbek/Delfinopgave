/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.Discipline.*;

/**
 *
 * @author Michael
 */
public class Result {
    private int id;
    private Discipline disc;
    private int time;
    
    public Result(int id, Discipline disc, int tid) {
        this.id = id;
        this.disc = disc;
        this.time = tid;
    }
    private String timeConverter() {
        String s = String.valueOf(time);
        if (s.length()==3) {
            String s1 = s.substring(0,s.length()-2);
            String s2 = s.substring(s.length()-2);
            return s1+":"+s2;
        } else {
            return s;
        }
    }

    public int getId() {
        return id;
    }

    
    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "medlemsnummer: " + id + "\tDisciplin: " + disc + "\ttid: " + timeConverter();
    }
}
