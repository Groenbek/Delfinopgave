package mappers;

import datasovs.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import people.Member;

public class MemberToTeam {

    Connection con = null;

    public void insertMember(Member member) {
        try {
            String SQL = "INSERT INTO Members (team_id, m_id, m_type, haspaid) VALUES (?, ?, ?, ?)";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getmName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getActOrPas());
            ps.setString(4, member.getCompetitive());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
