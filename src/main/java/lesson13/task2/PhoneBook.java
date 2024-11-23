package lesson13.task2;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public void info() {
        for (Contact contact : contacts) {
            System.out.println("Имя " + contact.getSurname());
            System.out.println("Телефоны: ");
            for (String phoneNumber : contact.getPhoneNumber()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }

    public void add(String surname, String phoneNumber) {
        boolean contactExists = false;
        for (Contact contact : contacts) {
            if (contact.getSurname().equals(surname)) {
                contact.getPhoneNumber().add(phoneNumber);
                contactExists = true;
                break;
            }
        }
        if (!contactExists) {
            contacts.add(new Contact(surname, phoneNumber));
        }
    }

    public void get(String surname) {
        for (Contact contact : contacts) {
            if (contact.getSurname().equals(surname)) {
                System.out.println("Имя: " + contact.getSurname());
                System.out.println("Телефоны: ");
                for (String phoneNumber : contact.getPhoneNumber()) {
                    System.out.println(phoneNumber);
                }
            }
        }
    }
}