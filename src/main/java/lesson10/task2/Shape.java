package lesson10.task2;

import java.text.DecimalFormat;

public interface Shape {

    default String calculationPerimeterTriangle(double sideA, double sideB, double sideC) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(sideA + sideB + sideC);
    }

    default String calculationAreaTriangle(double sideA, double sideB, double sideC) {
        DecimalFormat df = new DecimalFormat("#.##");
        double p = Double.parseDouble(calculationPerimeterTriangle(sideA, sideB, sideC)) / 2;
        return df.format(Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)));
    }

    default String calculationPerimeterCircle(double radius) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(2 * Math.PI * radius);
    }

    default String calculationAreaCircle(double radius) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(Math.PI * Math.pow(radius, 2));
    }

    default double calculationPerimeterRectangle(double length, double width) {
        return 2 * (length + width);
    }

    default double calculationAreaRectangle(double length, double width) {
        return length * width;
    }
}

