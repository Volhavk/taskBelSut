package task1.rectangle;

import task1.Color;
import task1.Figure;
import task1.Paper;

public class PaperRectangle extends Rectangle implements Paper {

    private int length;
    private int width;
    private double area;
    private int perimeter;

    public PaperRectangle(int length, int width, PaperRectangle rectangle){
        this.length = length;
        this.width = width;
        this.area = length*width;
        this.perimeter = (length + width)*2;
        if(rectangle.getArea() < 0){
            System.out.println("Impossible to cut");
        }
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
        return "it's paper rectangle with area = " + area;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
