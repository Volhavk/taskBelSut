package task1.circle;

import task1.Color;
import task1.Figure;
import task1.Material;
import task1.Paper;

import java.util.Objects;

public abstract class Circle extends Figure {

    private static Color color;
    private double radius;
    private double perimeter;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        this.perimeter = Math.PI*radius*2;
        this.area = Math.PI * Math.pow(radius, 2);
//        if (rectangle.getArea() < 0) {
//            System.out.println("Impossible to cut");
//        }
    }

    public Circle(Material material) {
        area = ((Figure) material).getArea() / 2;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                Double.compare(circle.perimeter, perimeter) == 0 &&
                Double.compare(circle.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, perimeter, area);
    }

    public static class PaperCircle extends Circle implements Paper {

        public PaperCircle(Paper paper) {
            super(paper);
        }

        @Override
        public Color paint(Color color) {
            if (Circle.color == null) {
                Circle.color = color;
            }
            return Circle.color;
        }

        @Override
        public Color getColor() {
            return color;
        }

    }
}

