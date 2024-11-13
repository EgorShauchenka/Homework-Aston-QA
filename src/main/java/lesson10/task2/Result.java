package lesson10.task2;

public class Result {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("Черный", "Белый", 10, 15, 20);
        Circle circle = new Circle("Желтый", "Черный", 15);
        Rectangle rectangle = new Rectangle("Зеленый", "Красный", 15, 25);

        triangle.displayInfo();
        circle.displayInfo();
        rectangle.displayInfo();


        // Данные методы это default интерфейса Shape.
        System.out.println(triangle.calculationPerimeterTriangle(15, 20, 25));
        System.out.println(triangle.calculationAreaTriangle(15, 20, 25));

        System.out.println(circle.calculationPerimeterCircle(25));
        System.out.println(circle.calculationAreaCircle(25));

        System.out.println(rectangle.calculationPerimeterRectangle(10, 20));
        System.out.println(rectangle.calculationAreaRectangle(10, 20));


    }
}
