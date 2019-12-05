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
import model.Member;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class MemberMap {

    //Is used in every method for connection to database
    private Connection con = null;

    //Building member objects from values in database and return an arraylist of those members objects
    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList();
        try {
            con = DBConnector.getConnection();
            String SQL = "SELECT * FROM dolphinclub.members";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int mId = rs.getInt("m_id");
                String name = rs.getString("m_name");
                int age = rs.getInt("age");
                String actOrPas = rs.getString("act_or_pas");
                String competitive = rs.getString("competitive");
                Member member = new Member(mId, name, age, actOrPas, competitive);
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    //Building member objects from values in two tables from database and return an arraylist.
    public ArrayList<Member> getMembersInTeam(int teamID) {
        ArrayList<Member> members = new ArrayList();
        try {
            con = DBConnector.getConnection();
            String SQL = "SELECT distinct dolphinclub.members.m_id, m_name, age, act_or_pas, competitive FROM dolphinclub.members, dolphinclub.memberstotraining "
                    + "WHERE memberstotraining.m_id = members.m_id AND memberstotraining.t_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, teamID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int mId = rs.getInt("m_id");
                String name = rs.getString("m_name");
                int age = rs.getInt("age");
                String actOrPas = rs.getString("act_or_pas");
                String competitive = rs.getString("competitive");
                Member member = new Member(mId, name, age, actOrPas, competitive);
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    //Inserting member object into members table in database, with member object as parameter
    public void insertMember(Member member) {
        try {
            String SQL = "INSERT INTO dolphinclub.members (m_name, age, act_or_pas, competitive) VALUES (?, ?, ?, ?)";
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

    //Return greatest value of member ID from members table in database
    public int getMemberId() {
        int returnId = 0;
        try {
            Connection con = DBConnector.getConnection();
            String sql = "select max(m_id) from dolphinclub.members";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                returnId += rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnId;
    }
}