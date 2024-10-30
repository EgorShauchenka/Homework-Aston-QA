package lesson6.task2;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName,
                    String position,
                    String email,
                    String phone,
                    int salary,
                    int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void displayInformation() {
        System.out.println(
                "ФИО: " + fullName + "\n" +
                        "Должность: " + position + "\n" +
                        "Email: " + email + "\n" +
                        "Телефон: " + phone + "\n" +
                        "Зарплата: " + salary + "\n" +
                        "Возраст: " + age);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
