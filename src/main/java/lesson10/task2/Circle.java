package lesson10.task2;

import java.text.DecimalFormat;

public class Circle implements ShapeInterface, Shape {
    private String fillColor;
    private String borderColor;
    private double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculationPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculationArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void displayInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Фигура: Круг");
        System.out.println("Периметр: " + df.format(calculationPerimeter()));
        System.out.println("Площадь: " + df.format(calculationArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                ", radius=" + radius +
                '}';
    }
}
