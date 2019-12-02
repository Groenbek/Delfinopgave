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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Members");

            while (rs.next()) {
                int id = rs.getInt("m_id");
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

    //ResultSet ids = ps.getGeneratedKeys();
    //ids.next();
    //int id = ids.getInt(1);
    //member.setId(id);
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
