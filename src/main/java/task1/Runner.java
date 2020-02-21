package task1;

import task1.model.Color;
import task1.model.circle.PlasticCircle;
import task1.model.rectangle.Rectangle;
import task1.model.triangle.Triangle;

import java.io.*;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Rectangle.PaperRectangle paperRectangle = new Rectangle.PaperRectangle(10, 20);
        Rectangle.PaperRectangle paperRectangle1 = new Rectangle.PaperRectangle(10, 20);
        PlasticCircle plasticCircle = new PlasticCircle(15);
        Box box = new Box();

        box.addFigure(paperRectangle);
        box.addFigure(plasticCircle);

        box.addFigure(paperRectangle1);

        box.removeFigure(-1);

        FileHandler.saveToFile(box);
        try {
            FileHandler.loadBoxesFromFile(); //perimeter of circles is transient; area of rectangles is static
        } catch (EOFException exc) {
            System.out.println("End of file reached");
        }

    }
}
