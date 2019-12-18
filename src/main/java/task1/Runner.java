package task1;

import task1.model.Color;
import task1.model.circle.PlasticCircle;
import task1.model.rectangle.Rectangle;
import task1.model.triangle.Triangle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Runner {
    public static void main(String[] args) throws IOException {
        Rectangle.PaperRectangle paperRectangle = new Rectangle.PaperRectangle(10, 20);
        Triangle.PaperTriangle paperTriangle = new Triangle.PaperTriangle(paperRectangle);
        PlasticCircle plasticCircle = new PlasticCircle(15);
        Box box = new Box();
        Box box2 = new Box();

//        paperRectangle.paint(Color.GREEN);
//        System.out.println(paperRectangle.getColor());
//
        box.addFigure(paperRectangle);
        box.addFigure(plasticCircle);
//        box.addFigure(plasticCircle);
//        box.getFigure(0);
//
//        box.replaceFigure(1, paperRectangle);
//        box.getNumberOfFigures();
//        box.findFigureWithParameters(200, 60);
//        box.getAllCircles();
//
//        System.out.println(box.getAllFigures());
//        System.out.println("Total area is " + box.getTotalAres());
//        System.out.println("Total perimeter is " + box.getTotalPerimeter());

        FileHandler.saveToFile(box);
        FileHandler.saveToFile(box2);
        FileHandler.loadFromFile(); //perimeter of circles is transient; area of rectangles is static

    }
}
