package com.basecamp.contactmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public void createContact(Contact contact) {
        String sql = "INSERT INTO contacts (name, phone, email, address, group_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getAddress());
            stmt.setInt(5, contact.getGroup().getGroupId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Connection conn = DbFunctions.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int contactID = rs.getInt("id");
                String contactName = rs.getString("name");
                String contactPhone = rs.getString("phone");
                String contactEmail = rs.getString("email");
                String contactAddress = rs.getString("address");
                int groupId = rs.getInt("group_id");
                String groupName = rs.getString("name");
                Group group = new Group(groupId, groupName);
                Contact contact = new Contact(contactID, contactName, contactPhone, contactEmail, contactAddress, group);
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private Group getGroupByID(int groupId) {
        String sql = "SELECT * FROM groups where id = ?";
        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
                 stmt.setInt(1, groupId);
                 ResultSet rs = stmt.executeQuery();
                 if (rs.next()){
                     return new Group(rs.getInt("group_id"), rs.getString("name"));
                 }
        } catch (SQLException e){
                 e.printStackTrace();
        }
        return null;
    }

    public void updateContact(Contact contact) {
        String sql = "UPDATE contacts SET name = ?, phone = ?, email = ?, address = ?, group_id = ? WHERE id = ?";
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