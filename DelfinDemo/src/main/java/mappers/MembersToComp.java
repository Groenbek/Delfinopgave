package mappers;

import datasovs.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CompScore;
import model.SwimEvent;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MembersToComp {

    //Is used in every method for connection to database
    Connection con = null;

    //Insert parameter values into memberstoevent table in database
    public void registerEventResult(int seId, int mId, int dId, int sePlacement) {
        try {
            String SQL = "INSERT INTO memberstoevent (se_id, m_id, d_id, se_placement) VALUES (?, ?, ?, ?)";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, seId);
            ps.setInt(2, mId);
            ps.setInt(3, dId);
            ps.setInt(4, sePlacement);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Update memberstoevent table in database, with values from parameters
    public void updateEventResult(int newResult, int mId, int disc) {
        try {
            String SQL = "UPDATE memberstoevent SET se_placement =? WHERE m_id = ? AND d_id = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, newResult);
            ps.setInt(2, mId);
            ps.setInt(3, disc);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Insert parameter values into swimevent table in database
    public void registerSwimEvent(String seDate, String seName) {
        try {
            String SQL = "INSERT INTO swimevent (se_date, se_name) VALUES (?, ?) ";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, seDate);
            ps.setString(2, seName);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Returns arraylist of all swimevent objects created from swimevent table in database
    public ArrayList<SwimEvent> getSwimEvents() {
        ArrayList<SwimEvent> swimEvents = new ArrayList();
        try {
            String SQL = "SELECT * FROM swimevent";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int seId = rs.getInt("se_id");
                String seDate = rs.getString("se_date");
                String seName = rs.getString("se_name");
                SwimEvent se = new SwimEvent(seId, seDate, seName);
                swimEvents.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return swimEvents;
    }

    //Insert parameter values into memberstoevent table in database
    public void registerSwimmerToSwimEvent(int seId, int mId, int dId, int sePlacement) {
        try {
            String SQL = "INSERT INTO memberstoevent (se_id, m_id, d_id, se_placement) VALUES (?, ?, ?, ?) ";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, seId);
            ps.setInt(2, mId);
            ps.setInt(3, dId);
            ps.setInt(4, sePlacement);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Returns arraylist of all CompScore objects built from memberstoevent table in database
    public ArrayList<CompScore> getAllMemberAndScores() {
        ArrayList<CompScore> leaderBoard = new ArrayList();
        try {
            String SQL = "SELECT * FROM memberstoevent";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int seId = rs.getInt("se_id");
                int mId = rs.getInt("m_id");
                int dId = rs.getInt("d_id");
                int placement = rs.getInt("se_placement");
                CompScore lb = new CompScore(seId, mId, dId, placement);
                leaderBoard.add(lb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leaderBoard;
    }
}