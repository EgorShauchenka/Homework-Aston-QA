package lesson10.task2;

import java.text.DecimalFormat;

public class Triangle implements ShapeInterface, Shape {
    private String fillColor;
    private String borderColor;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculationPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculationArea() {
        double p = calculationPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void displayInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Фигура: Треугольник");
        System.out.println("Периметр: " + df.format(calculationPerimeter()));
        System.out.println("Площадь: " + df.format(calculationArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                '}';
    }
}
