package mappers;

import datasovs.DBConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Discipline;
import static model.Discipline.*;
import model.Result;

public class MemberTraining {
    Connection con = null;

    public ArrayList<Result> getResults() {

        ArrayList<Result> results = new ArrayList();

        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Memberstotraining");

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
    public static void main(String[] args) {
        ArrayList<Result> resArray = new MemberTraining().getResults();
        
        for (Result r: resArray) {
            System.out.println(r);
        }
    }
}
