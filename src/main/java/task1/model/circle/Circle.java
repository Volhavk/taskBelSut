package task1.model.circle;

import task1.model.Color;
import task1.model.Figure;
import task1.materials.Material;
import task1.materials.Paper;

import java.util.Objects;

public abstract class Circle extends Figure {

    private static Color color = null;
    private double radius;
    transient double perimeter;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        this.perimeter = Math.PI * radius * 2;
        this.area = Math.PI * Math.pow(radius, 2);
    }

    public Circle(Material material) {
        area = ((Figure) material).getArea() / 3;
        perimeter = ((Figure) material).getPerimeter() / 2;
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

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", area=" + area +
                '}';
    }

    public static class PaperCircle extends Circle implements Paper {

        public PaperCircle(double radius) {
            super(radius);
        }

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

