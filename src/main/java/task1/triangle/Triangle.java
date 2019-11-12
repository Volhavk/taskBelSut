package task1.triangle;

import task1.Color;
import task1.Figure;
import task1.Paper;

public abstract class Triangle extends Figure {

    private int triangleSide;
    private double area;
    private static Color color;

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }


    public static class PaperTriangle extends Triangle implements Paper {


        @Override
        public Color paint(Color color) {
            return null;
        }

        @Override
        public Color getColor() {
            return null;
        }
    }

}
