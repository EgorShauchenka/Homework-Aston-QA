package lesson10.task1;

public abstract class Animal implements AnimalsMethods {
    private static int animalCount;
    private String name;
    private int age;
    private int runObstacle;
    private int swimObstacle;

    public Animal(String name, int age, int runObstacle, int swimObstacle) {
        this.name = name;
        this.age = age;
        this.runObstacle = runObstacle;
        this.swimObstacle = swimObstacle;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return this.name;
    }

    public int getRunObstacle() {
        return runObstacle;
    }

    public int getSwimObstacle() {
        return swimObstacle;
    }

    @Override
    public abstract void run(int distance);


    @Override
    public abstract void swim(int distance);

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
