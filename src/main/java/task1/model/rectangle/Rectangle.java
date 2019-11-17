package task1.model.rectangle;

import task1.model.Color;
import task1.model.Figure;
import task1.materials.Material;
import task1.materials.Paper;


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
//        if (rectangle.getArea() < 0) {
//            System.out.println("Impossible to cut");
//        }
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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
