package mappers;

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
    //Connection con = null;

    //Get ID from a database, way better than manual counter.
    //PreparedStatement os = con.prepareStatement(SQL, Statement.RETURN_GENERATTED_KEYS);
    //Return an ArrayList with all existing pizzas in database
    /*  public ArrayList<Member> getMembers() {
    
    ArrayList<Member> members = new ArrayList();
    
    try {
    con = DBConnector.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM Members");
    
    while (rs.next()) {
    int id = rs.getInt("M_ID");
    int age = rs.getInt("M_AGE");
    String name = rs.getString("M_NAME");
    String act = rs.getString("M_ACT");
    //Member member = new Member(id, age, name, act);
    //members.add(member);
    
    }
    
    } catch (SQLException ex) {
    Logger.getLogger(MemberMap.class.getName()).log(Level.SEVERE, null, ex);
    }
    return members;
    }
    
    public void insertMember(Member member) {
    try {
    String SQL = "INSERT INTO Members (M_ID, M_AGE, M_NAME, M_ACT) VALUES (?, ?, ?, ?)";
    con = DBConnector.getConnection();
    PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, member.getId());
    ps.setInt(2, member.getAge());
    ps.setString(3, member.getName());
    ps.setString(4, member.getActivity());
    ps.executeUpdate();
    
    //ResultSet ids = ps.getGeneratedKeys();
    //ids.next();
    //int id = ids.getInt(1);
    //member.setId(id);
    
    
    } catch (SQLException ex) {
    Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    */
    }