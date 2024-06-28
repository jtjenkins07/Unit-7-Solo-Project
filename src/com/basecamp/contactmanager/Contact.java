package com.basecamp.contactmanager;

public class Contact {
    private int contactId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Group group;

    public Contact(int contactId, String name, String phone, String email, String address, Group group) {
        this.contactId = contactId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.group = group;
    }

    public int getContactId() {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", group=" + group +
                '}';
    }
}
