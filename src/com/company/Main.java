package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scann = new Scanner(System.in);
    public static Phone device = new Phone();
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            int opc = showMenu();
            switch (opc) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    createNewContact();
                    break;
                case 2:
                    addPhoneToContact();
                    break;
                case 3:
                    updateContactName();
                    break;
                case 4:
                    updateContactNumber();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    deleteNumberFromContact();
                    break;
                case 7:
                    showAllContacts();
                    break;
                case 8:
                    getContactByName();
                    break;
                case 9:
                    getContactByPhone();
                    break;
            }
        }
    }

    public static int showMenu() {
        System.out.println("Select an option: ");
        System.out.println("\t 0.- Exit");
        System.out.println("\t 1.- Create New Contact");
        System.out.println("\t 2.- Create new phone to existing contact");
        System.out.println("\t 3.- Update contact name");
        System.out.println("\t 4.- Update contact number");
        System.out.println("\t 5.- Delete contact");
        System.out.println("\t 6.- Delete number contact");
        System.out.println("\t 7.- See full directory");
        System.out.println("\t 8.- Look at to contact by name");
        System.out.println("\t 9.- Look at to contact by phone");
        return scann.nextInt();
    }

    public static void createNewContact() {
        System.out.print("Type the new contact name: ");
        scann.nextLine();
        String contactName = scann.nextLine();
        System.out.print("Type the new contact number phone: ");
        String phoneNumber = scann.nextLine();
        System.out.println(contactName + phoneNumber);
        Contact newContact = device.createContact(contactName, phoneNumber);
        System.out.println("A new Contact has been created.");
        device.getContactDetails(newContact);
        scann.nextLine();
    }

    public static void addPhoneToContact() {
        System.out.print("Type the new contact name: ");
        scann.nextLine();
        String contactName = scann.nextLine();
        System.out.print("Type the new contact number phone: ");
        String phoneNumber = scann.nextLine();
        Contact newContact = device.addNumberToExistingContact(contactName, phoneNumber);
        if(newContact!=null) {
            System.out.println("The contact has been updated.");
            device.getContactDetails(newContact);
        } else {
            System.out.println("There's no contact with that name");
        }
    }

    public static void  updateContactName() {
        System.out.print("Type the current contact name: ");
        scann.nextLine();
        String currentContactName = scann.nextLine();
        System.out.print("Type the new contact name: ");
        String newContactName = scann.nextLine();
        Contact updatedContact = device.updateContact(currentContactName, newContactName);
        if(updatedContact != null) {
            System.out.println("The contact has been updated");
            device.getContactDetails(updatedContact);
        } else {
            System.out.println("The contact doesn't exists");
        }
    }

    public static void updateContactNumber() {
        System.out.print("Type the current contact name: ");
        scann.nextLine();
        String currentContactName = scann.nextLine();
        System.out.print("Type the current phone number: ");
        String currentPhoneNumber = scann.nextLine();
        System.out.print("Type the current phone number: ");
        String newPhoneNumber = scann.nextLine();
        Contact updatedContact = device.updateContact(currentContactName, currentPhoneNumber, newPhoneNumber);
        if(updatedContact != null) {
            System.out.println("The contact has been updated");
            device.getContactDetails(updatedContact);
        } else {
            System.out.println("The contact or the number phone doesn't exists");
        }
    }

    public static void deleteContact() {
        System.out.print("Type the contact name to delete: ");
        scann.nextLine();
        String currentContactName = scann.nextLine();
        Contact deletedContact = device.deleteContact(currentContactName);
        if(deletedContact != null) {
            System.out.println("The contact has been deleted");
            device.getContactDetails(deletedContact);
        } else {
            System.out.println("The contact doesn't exists");
        }
    }

    public static void deleteNumberFromContact() {
        System.out.print("Type the contact name: ");
        scann.nextLine();
        String currentContactName = scann.nextLine();
        System.out.print("Type the phone number to delete: ");
        String targetPhone = scann.nextLine();
        Contact deletedContact = device.deleteContact(currentContactName, targetPhone);
        if(deletedContact != null) {
            System.out.println("The contact phone has been deleted");
            device.getContactDetails(deletedContact);
        } else {
            System.out.println("The contact doesn't exists");
        }
    }

    public static void showAllContacts() {
        device.getAllContactsNames();
    }

    public static void  getContactByName() {
        System.out.print("Type the name of the contact you're looking for: ");
        scann.nextLine();
        device.getContactDetails(scann.nextLine());
    }

    public static void  getContactByPhone() {
        System.out.print("Type the phone of the contact you're looking for: ");
        scann.nextLine();
        device.getContactDetailsByPhone(scann.nextLine());
    }
}
