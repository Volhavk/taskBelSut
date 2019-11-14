package task1.triangle;

import task1.Color;
import task1.Figure;
import task1.Material;
import task1.Paper;

public abstract class Triangle extends Figure {

    private double area;
    private static Color color = null;
    private double perimeter;
    private double baseOfTriangle;
    private double side1;
    private double side2;
    private double height;


    public Triangle(double baseOfTriangle, double height, double side1, double side2) {
        this.baseOfTriangle = baseOfTriangle;
        this.height = height;
        this.area = baseOfTriangle * height / 2;
        this.perimeter = baseOfTriangle + side1 + side2;
    }

    public Triangle(Material material) {
        area = ((Figure) material).getArea() / 2;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "it's paper triangle with area = " + area;
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
