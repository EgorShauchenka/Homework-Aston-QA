package lesson10.task1;

public class Cat extends Animal implements AnimalsMethods {
    public static int catCount;
    public int appetite;
    public boolean satiety;

    public Cat(String name, int age, int appetite) {
        super(name, age, 200, 0);
        this.appetite = appetite;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= getAppetite()) {
            plate.reductionFood(appetite);
            satiety = true;
            System.out.println("Кот " + getName() + " покушал,его аппетит " + getAppetite());
        } else {
            satiety = false;
            System.out.println("Кот " + getName() + " не покушал, не хватило еды в тарелке.");
        }
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
        if (getSwimObstacle() == 0) {
            System.out.println(getName() + " не умеет плавать");
        }
    }
}
