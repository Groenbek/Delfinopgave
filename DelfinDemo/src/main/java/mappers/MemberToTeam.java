package mappers;

import datasovs.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Discipline;
import model.Result;

public class MemberToTeam {

    Connection con = null;

    public void insertMember(int mId, int tId, int mType, String hasPaid) {
        try {
            String SQL = "INSERT INTO memberstoteam (m_id, team_id, m_type, haspaid) VALUES (?, ?, ?, ?)";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mId);
            ps.setInt(2, tId);
            ps.setInt(3, mType);
            ps.setString(4, hasPaid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap<Integer, String> getRestance() {
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        try {
            String SQL = "SELECT memberstoteam.m_id, haspaid, m_name FROM memberstoteam, members WHERE members.m_id = memberstoteam.m_id;";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("m_id");
                String hasPaid = "\tNavn: " + rs.getString("m_name")+"\t\tStatus: "+rs.getString("haspaid");
                hashmap.put(id, hasPaid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashmap;
    }

    public void updateRestance(int mId, String hasPaid) {
        try {
            String SQL = "UPDATE memberstoteam SET haspaid =? WHERE m_id = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hasPaid);
            ps.setInt(2, mId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
