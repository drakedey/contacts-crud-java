package com.company;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    public Contact(String name, String phoneNumber) {
        this.name = name;
        addNumber(phoneNumber);
    }

    public void addNumber(String newNumber) {
        phoneNumbers.add(newNumber);
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
