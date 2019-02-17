package com.company;

import java.util.ArrayList;

public class Phone {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public Contact createContact(String name, String phone) {
        Contact existingContact = getContactByName(name);
        if(existingContact == null) {
            Contact newContact = new Contact(name, phone);
            contacts.add(newContact);
            return newContact;
        }
        addNumberToExistingContact(existingContact, phone);
        return existingContact;
    }

    public Contact deleteContact(String name) {
        Contact deletedContact = getContactByName(name);
        if(deletedContact != null) {
            contacts.remove(deletedContact);
            return deletedContact;
        }
        return null;
    }

    public Contact deleteContact(String name, String phoneNumber) {
        Contact deletedContact = getContactByName(name);
        if(deletedContact != null) {
            int phoneIndex = checkIfPhoneNumberExists( deletedContact, phoneNumber );
            if(phoneIndex >= 0) {
                deletedContact.getPhoneNumbers().remove(phoneIndex);
                return deletedContact;
            }
        }
        return null;
    }

    public Contact updateContact(String currentName, String newName) {
        Contact targetContact = getContactByName(currentName);
        if(targetContact != null) {
            targetContact.setName(newName);
            return targetContact;
        }
        return null;
    }

    public Contact updateContact(String currentName, String currentPhoneNumber, String newPhoneNumber) {
        Contact targetContact = getContactByName(currentName);
        if(targetContact!=null) {
            int phoneIndex = checkIfPhoneNumberExists( targetContact, currentPhoneNumber);
            if(phoneIndex >= 0) {
                targetContact.getPhoneNumbers().set(phoneIndex, newPhoneNumber);
                return targetContact;
            }
        }
        return null;
    }

    public Contact addNumberToExistingContact(String name, String phone) {
        Contact contact = getContactByName(name);
        if(contact != null) {
            int phoneIndex = checkIfPhoneNumberExists(contact, phone);
            if(phoneIndex > 0)
                return contact;
            contact.getPhoneNumbers().add(phone);
            return  contact;
        }
        return null;
    }

    public void getContactDetailsByPhone(String phoneNumber) {
        ArrayList<Contact> contacts = getContactsByPhone(phoneNumber);
        if(contacts == null) {
            System.out.println("There's no contact associated to that number");
            return;
        }
        for (Contact contact :
                contacts) {
            getContactDetails(contact);
        }
    }

    public void getContactDetails(String name) {
        Contact targetContact = getContactByName(name);
        if(targetContact == null) {
            System.out.println("The given name doesn't exits");
        } else {
            ArrayList<String> phones = targetContact.getPhoneNumbers();
            System.out.println("=========================");
            System.out.println("Contact details: ");
            System.out.println("=========================");
            System.out.print("name: " + targetContact.getName() + "\n");
            System.out.print("phones: " + (phones.size() > 0 ? "The user doesn't have phone registered" : "") + "\n");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println("\t(" + (i+1) + ") " + phones.get(i));
            }
        }
    }

    public void getContactDetails(Contact contact) {
        ArrayList<String> phones = contact.getPhoneNumbers();
        System.out.println("=========================");
        System.out.println("Contact details: ");
        System.out.println("=========================");
        System.out.print("name: " + contact.getName() + "\n");
        System.out.print("phones: " + (phones.size() <= 0 ? "The user doesn't have phone registered" : "") + "\n");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println("\t(" + (i+1) + ") " + phones.get(i));
        }
    }

    public void getAllContactsNames() {
        if(contacts.size() > 0)
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("("+(i+1)+") " + contacts.get(i).getName());
            }
        else
            System.out.println("You don't have contacts registered");
    }

    public void getAllContactsDetails() {
        if(contacts.size() > 0)
            for (Contact contact : contacts) {
                getContactDetails(contact);
            }
        else
            System.out.println("You don't have contacts registered");
    }

    private ArrayList<Contact> getContactsByPhone(String phone) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (Contact contact :this.contacts){
            System.out.println(phone);
            System.out.println(checkIfPhoneNumberExists(contact, phone));
            if(checkIfPhoneNumberExists(contact, phone) >= 0) {
                contacts.add(contact);
            }
        }
//        System.out.println(contacts.get(0) + " " + contacts.size() );
        return contacts.size() > 0 ? contacts : null;
    }

    private int checkIfPhoneNumberExists(Contact contact, String currentNumber) {
        for (int i = 0; i < contact.getPhoneNumbers().size(); i++) {
            if(contact.getPhoneNumbers().get(i).equals(currentNumber)) {
                System.out.println("Here");
                return i;
            }
        }
        return -1;
    }

    private Contact getContactByName(String name) {
        if(contacts.size() > 0)
            for (Contact contact : contacts) {
                if (contact.getName().equals(name))
                    return contact;
            }
        return null;
    }

    private void addNumberToExistingContact(Contact contact, String newPhoneNumber) {
        if(checkIfPhoneNumberExists(contact, newPhoneNumber) < 0)
            contact.getPhoneNumbers().add(newPhoneNumber);
    }



}
