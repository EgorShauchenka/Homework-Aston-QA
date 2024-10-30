package lesson6;

import com.github.javafaker.Faker;
import java.util.Locale;

public class Data {
    public static Faker faker = new Faker(new Locale("ru"));
    public static Faker englishFaker = new Faker(new Locale("en"));

    public static String getFullName() {
        return faker.name().fullName();
    }

    public static String getPosition() {
        return faker.job().position();
    }

    public static String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static int getSalary() {
        return faker.number().numberBetween(2000, 4000);
    }

    public static int getAge() {
        return faker.number().numberBetween(18, 42);
    }

    public static String getEmail() {
        return englishFaker.internet().emailAddress();
    }
}
