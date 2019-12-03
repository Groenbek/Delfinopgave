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
import people.Member;

public class MemberMap {

    Connection con = null;

    //Get ID from a database, way better than manual counter.
    //PreparedStatement os = con.prepareStatement(SQL, Statement.RETURN_GENERATTED_KEYS);
    //Return an ArrayList with all existing pizzas in database
    public ArrayList<Member> getMembers() {

        ArrayList<Member> members = new ArrayList();

        try {
            con = DBConnector.getConnection();
            String SQL = "SELECT * FROM Members";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rs.next();
                String name = rs.getString("m_name");
                int age = rs.getInt("age");
                String actOrPas = rs.getString("act_or_pas");
                String competitive = rs.getString("competitive");
                Member member = new Member(name, age, actOrPas, competitive);
                members.add(member);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public ArrayList<Member> getMembersInTeam(int teamID) {
        ArrayList<Member> members = new ArrayList();
        try {
            con = DBConnector.getConnection();
            String SQL = "SELECT distinct members.m_id, m_name, age, act_or_pas, competitive FROM members, memberstotraining "
                    + "WHERE memberstotraining.m_id = members.m_id AND memberstotraining.t_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, teamID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("m_name");
                int age = rs.getInt("age");
                String actOrPas = rs.getString("act_or_pas");
                String competitive = rs.getString("competitive");
                Member member = new Member(name, age, actOrPas, competitive);
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public void insertMember(Member member) {
        try {
            String SQL = "INSERT INTO Members (m_name, age, act_or_pas, competitive) VALUES (?, ?, ?, ?)";
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
