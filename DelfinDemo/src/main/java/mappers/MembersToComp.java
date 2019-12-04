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
import model.SwimEvent;

public class MembersToComp {

    Connection con = null;

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

    public ArrayList<SwimEvent> getSwimEvents() {
        System.out.println("henrik1");
        ArrayList<SwimEvent> swimEvents = new ArrayList();
        try {
            String SQL = "SELECT * FROM swimevent";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int seId = rs.getInt("se_id");
                String seDate = rs.getString("se_date");
                String seName = rs.getString("se_date");
                SwimEvent se = new SwimEvent(seId, seDate, seName);
                swimEvents.add(se);
            }
            System.out.println("henrik2");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("henrik3");
        return swimEvents;
    }

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

    public static void main(String[] args) {
        new MembersToComp().registerSwimmerToSwimEvent(1, 1, 1, 1);
    }

}
