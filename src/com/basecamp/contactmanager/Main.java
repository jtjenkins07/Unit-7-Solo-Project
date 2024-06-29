package com.basecamp.contactmanager;
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
                    Group group = new Group(category,null);
                    Contact contact = new Contact(0,name,phone,email,address, group);
                    contactDAO.createContact(contact);
                    break;
                    case 2:
                    System.out.println("2");
                    break;
                    case 3:
                    System.out.println("3");
                    break;
                    case 4:
                    System.out.println("4");
                    break;
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
