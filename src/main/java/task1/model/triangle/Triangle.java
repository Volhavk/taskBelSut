package task1.model.triangle;

import task1.model.Color;
import task1.model.Figure;
import task1.materials.Material;
import task1.materials.Paper;

import java.util.Objects;

public abstract class Triangle extends Figure {

    private double area;
    private static Color color = null;
    private double perimeter;
    private double baseOfTriangle;

    private double height;


    public Triangle(double baseOfTriangle, double height) {
        this.baseOfTriangle = baseOfTriangle;
        this.height = height;
        this.area = baseOfTriangle * height / 2;
        this.perimeter = baseOfTriangle * 3;
    }

    public Triangle(Material material) {
        area = ((Figure) material).getArea() / 3;
        perimeter = ((Figure) material).getPerimeter() / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.area, area) == 0 &&
                Double.compare(triangle.perimeter, perimeter) == 0 &&
                Double.compare(triangle.baseOfTriangle, baseOfTriangle) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, baseOfTriangle, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", baseOfTriangle=" + baseOfTriangle +
                ", height=" + height +
                '}';
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }


    public static class PaperTriangle extends Triangle implements Paper {

        public PaperTriangle(double baseOfTriangle, double height) {
            super(baseOfTriangle, height);
        }

        public PaperTriangle(Paper paper) {
            super(paper);
        }

        @Override
        public Color paint(Color color) {
            if (Triangle.color == null) {
                Triangle.color = color;
            }
            return Triangle.color;
        }

        @Override
        public Color getColor() {
            return color;
        }
    }
}
