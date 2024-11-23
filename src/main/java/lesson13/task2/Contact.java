package lesson13.task2;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String surname;
    private List<String> phoneNumber;

    public Contact(String surname, String phoneNumber) {
        this.surname = surname;

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        this.phoneNumber = phoneNumbers;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

