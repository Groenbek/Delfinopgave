package mappers;

import datasovs.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
}
