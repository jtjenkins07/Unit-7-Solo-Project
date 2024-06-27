package com.basecamp.contactmanager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO {
    public void createContact(Contact contact){
        String sql ="INSERT INTO contacts (name, phone, email, address, group_id) (?, ?, ?, ?, ?)";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2,contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getAddress());
            stmt.setInt(5, contact.getContactId());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}

public List<Contact> getAllContacts(){
    List<Contact> contacts = new ArrayList<>();
    String sql = "SELECT * FROM Contacts";
    try (Connection conn = DbFunctions.getConnection();
        Statement stmt = conn.createStatement();
        Resultset rs = stmt.executeQuery(sql)){
        while(rs.next()){
            contact.setID(rs.getInt("id"));
            contact.setName(rs.getString("name"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            contact.setAddress(rs.getString("address"));
            contact.setGroupID(rs.getInt("id"));
        }
    } catch(SQLException e){
        e.printStackTrace();
    }
    return contacts;
}