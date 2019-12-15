package task1;

import task1.model.Color;
import task1.model.circle.PlasticCircle;
import task1.model.rectangle.Rectangle;
import task1.model.triangle.Triangle;

public class Runner {
    public static void main(String[] args) {
        Rectangle.PaperRectangle paperRectangle = new Rectangle.PaperRectangle(10, 20);
        Triangle.PaperTriangle paperTriangle = new Triangle.PaperTriangle(paperRectangle);
        PlasticCircle plasticCircle = new PlasticCircle(15);
        Box box = new Box();

        paperRectangle.paint(Color.GREEN);
        System.out.println(paperRectangle.getColor());

//        box.addFigure(paperRectangle);
//        box.addFigure(paperTriangle);
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
//        System.out.println("Total perimiter is " + box.getTotalPerimeter());

        FileHandler.saveToFile(box);
        Box restored = FileHandler.loadFromFile();

    }
}
