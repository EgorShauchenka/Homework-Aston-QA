package lesson10.task1;

public class Result {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Вок", 2);
        Dog dog2 = new Dog("Рекс", 3);
        Cat cat1 = new Cat("Валик", 1, 20);
        Cat cat2 = new Cat("Бакс", 3, 40);
        Cat cat3 = new Cat("Макс", 5, 60);
        Cat cat4 = new Cat("Витек", 2, 10);

        dog1.run(150);
        dog2.run(550);
        dog1.swim(5);
        dog2.swim(-15);

        System.out.println();

        cat1.run(150);
        cat2.run(250);
        cat1.swim(100);
        cat2.swim(0);

        System.out.println();

        System.out.println("Общие количество животных " + Animal.getAnimalCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());

        System.out.println();

        Plate plate1 = new Plate(100);
        plate1.infoFood();

        cat1.eat(plate1);
        cat2.eat(plate1);
        plate1.infoFood();
        cat3.eat(plate1);
        cat4.eat(plate1); // а этому котику хватила еды)
        plate1.infoFood();

        System.out.println();

        Cat[] cats = {cat1, cat2, cat3, cat4};
        plate1.setFood(100);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate1);
            System.out.println(cats[i].isSatiety());
        }
    }
}
