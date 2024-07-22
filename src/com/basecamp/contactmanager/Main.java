package com.basecamp.contactmanager;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("1. Create Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter address: ");
                    String address= scanner.nextLine();
                    System.out.println("Choose Category: [1]Family [2]Friend [3] Coworker ");
                    int category = scanner.nextInt();
                    scanner.nextLine();
                    Group group = null;
                    switch (category){
                        case 1:
                            group = new Group(1, null);
                            break;
                        case 2:
                            group = new Group(2, null);
                            break;
                        case 3:
                            group = new Group(3, null);
                            break;
                        default:
                            System.out.println("Invalid choice. Contact not created.");
                            continue;
                    }
                    Contact contact = new Contact(0,name,phone,email,address,group);
                    contactDAO.createContact(contact);
                    System.out.println("Contact created.");
                    break;
                    case 2:
                        List<Contact> contacts = contactDAO.getAllContacts();
                        for (Contact contactList : contacts){
                            System.out.println(contactList);
                        }
                    break;
                    case 3:
                        System.out.println("Enter ID of contact to update: ");
                        int contactId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new phone number: ");
                        String newPhone = scanner.nextLine();
                        System.out.println("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.println("Enter new address: ");
                        String newAddress = scanner.nextLine();
                        System.out.println("Enter new group ID: ");
                        int newGroupId = scanner.nextInt();
                        Group newGroup = new Group(newGroupId, null);
                        Contact updatedContact = new Contact(contactId,newName,newPhone,newEmail,newAddress,newGroup);
                        contactDAO.updateContact(updatedContact);
                        scanner.nextLine();

                    break;
                    case 4:
                        System.out.println("Enter ID of contact to delete: ");
                        try {
                            int idToDelete = scanner.nextInt();
                            scanner.nextLine();
                            if (contactDAO.deleteContact(idToDelete)){
                                System.out.println("Contact Deleted.");
                            } else{
                                System.out.println("Contact not found, could not be deleted.");
                            }
                        }catch(InputMismatchException e){
                            System.out.println("Invalid input type, please enter a numeric value.");
                            scanner.nextLine();
                        }
                    case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    running = false;
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
