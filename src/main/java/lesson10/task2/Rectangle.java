package lesson10.task2;

import java.text.DecimalFormat;

public class Rectangle implements ShapeInterface, Shape {
    private String fillColor;
    private String borderColor;
    private double length;
    private double width;

    public Rectangle(String fillColor, String borderColor, double length, double width) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.length = length;
        this.width = width;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculationPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculationArea() {
        return length * width;
    }

    @Override
    public void displayInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Фигура: Прямоугольник");
        System.out.println("Периметр: " + df.format(calculationPerimeter()));
        System.out.println("Площадь: " + df.format(calculationArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}