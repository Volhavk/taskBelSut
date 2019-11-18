package task1.model.rectangle;

import task1.model.Color;
import task1.model.Figure;
import task1.materials.Material;
import task1.materials.Paper;

import java.util.Objects;


public abstract class Rectangle extends Figure {

    private int length;
    private int width;
    private double area;
    private double perimeter;
    private static Color color = null;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.area = length * width;
        this.perimeter = (length + width) * 2;
    }

    public Rectangle(Material material) {
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
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length &&
                width == rectangle.width &&
                Double.compare(rectangle.area, area) == 0 &&
                Double.compare(rectangle.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, area, perimeter);
    }

    public static class PaperRectangle extends Rectangle implements Paper {

        public PaperRectangle(int length, int width) {
            super(length, width);
        }

        public PaperRectangle(Paper paper) {
            super(paper);
            color = getColor();
        }

        @Override
        public Color paint(Color color) {
            if (Rectangle.color == null) {
                Rectangle.color = color;
            }
            return Rectangle.color;
        }

        @Override
        public Color getColor() {
            return color;
        }
    }

}
