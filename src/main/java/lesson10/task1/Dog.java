package lesson10.task1;

public class Dog extends Animal implements AnimalsMethods {
    public static int dogCount;

    public Dog(String name, int age) {
        super(name, age, 500, 10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Отрицательное значение для бега: " + getName());
            return;
        }
        if (distance <= getRunObstacle()) {
            System.out.println(getName() + " пробежал " + distance + " м");
        } else {
            System.out.println(getName() + " устал");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Отрицательное значение для плавания: " + getName());
            return;
        }
        if (distance <= getSwimObstacle()) {
            System.out.println(getName() + " проплыл " + distance + " м");
        } else {
            System.out.println(getName() + " устал");
        }
    }
}
