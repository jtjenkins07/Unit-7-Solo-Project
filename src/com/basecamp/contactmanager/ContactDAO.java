package com.basecamp.contactmanager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO {
    public void createContact(Contact contact){
        String sql ="INSERT INTO contacts (name, phone, email, address, group_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2,contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getAddress());
            stmt.setInt(5, contact.getGroup().getGroupId());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}

    public List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Connection conn = DbFunctions.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                int groupID = rs.getInt("group_id");
                Group group = getGroup
                Contact contact = new Contact(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("address"),
                group
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return contacts;
    }
    public void updateContact(Contact contact){
        String sql = "UPDATE contacts SET name = ?, phone = ?, email = ?, address = ?, groupID = ? WHERE id = ?";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getAddress());
            stmt.setInt(5, contact.getGroup().getGroupId());
            stmt.setInt(6, contact.getContactId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(int contactId) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contactId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
