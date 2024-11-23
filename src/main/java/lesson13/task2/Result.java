package lesson13.task2;

public class Result {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Samuseu", "+375333922190");
        phoneBook.add("Vasiliev", "+375333333333");
        phoneBook.add("Taranov", "+375295999999");
        phoneBook.add("Vasilevski", "+375333922190");
        phoneBook.add("Vasilevski", "+375333922191");
        phoneBook.add("Gysevski", "+375337777777");
        phoneBook.add("Kysnarenko", "+375337890000");


        phoneBook.info();

        phoneBook.get("Vasilevski");
        phoneBook.get("Taranov");
    }
}
