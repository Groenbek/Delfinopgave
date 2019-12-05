package mappers;

import datasovs.DBConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Discipline;
import static model.Discipline.*;
import model.Result;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MemberTraining {

    //Is used in every method for connection to database
    private Connection con = null;

    //Returns arraylist of result objects, with specific discipline ID as parameter
    public ArrayList<Result> getResults(int dId) {
        ArrayList<Result> results = new ArrayList();
        try {
            if (dId < 1 || dId > 4) {
                throw new IllegalArgumentException();
            }
            String SQL = "SELECT * FROM memberstotraining WHERE d_id = ?";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("m_id");
                Discipline discipline = convertIntToDiscipline(rs.getInt("d_id"));
                int time = rs.getInt("tid");
                Result res = new Result(id, discipline, time);
                results.add(res);
            }
        } catch (SQLException | IllegalArgumentException ex) {
            Logger.getLogger(MemberToTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    //Insert parameter values into memberstotraining table in database
    public void insertMember(int tId, int mId, int dId, int tid) {
        try {
            String SQL = "INSERT INTO memberstotraining (t_id, m_id, d_id, tid) VALUES (?, ?, ?, ?)";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tId);
            ps.setInt(2, mId);
            ps.setInt(3, dId);
            ps.setInt(4, tid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Convert integers 1 to 4 into discipline enum values
    private Discipline convertIntToDiscipline(int input) {
        if (input < 1 || input > 4) {
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

    //Update memberstotraining table in database, with values from parameters
    public void registerTrainingResult(int disciplin, int trainingdate, int tid, int mId) {
        try {
            String SQL = "UPDATE memberstotraining SET trainingdate = ?, tid = ? WHERE m_id = ? AND d_id = ?;";
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, trainingdate);
            ps.setInt(2, tid);
            ps.setInt(3, mId);
            ps.setInt(4, disciplin);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}