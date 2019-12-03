package mappers;

import datasovs.DBConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Discipline;
import static model.Discipline.*;
import model.Result;
import people.Member;

public class MemberTraining {
    Connection con = null;

    public ArrayList<Result> getResults(int tId) {

        ArrayList<Result> results = new ArrayList();

        try {
            String SQL = "SELECT * FROM Memberstotraining WHERE t_id = ?";
            con = DBConnector.getConnection();
            //Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tId);
            //ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("m_id");
                Discipline discipline = convertIntToDiscipline(rs.getInt("d_id"));
                int time = rs.getInt("tid");
                Result res = new Result(id, discipline, time);
                results.add(res);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberToTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    public void RegisterTime(int mId, int time) {
        String SQL = "SELECT ";
    }
    private Discipline convertIntToDiscipline(int input) {
        if (input<1||input>4) {
            throw new IllegalArgumentException();
        }
        switch (input) {
            case 1:
                return CRAWL;
            case 2:
                return BACKSTROKE;
            case 3:
                return BREASTSTROKE;
            case 4:
                return BUTTERFLY;
        }
        return null;
    }
}
