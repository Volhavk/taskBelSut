package task1;

import task1.rectangle.PlasticRectangle;
import task1.rectangle.Rectangle;

public class Runner {
    public static void main(String[] args) {
        Rectangle.PaperRectangle paperRectangle = new Rectangle.PaperRectangle(10,20);
        paperRectangle.paint(Color.RED);
        paperRectangle.paint(Color.GREEN);
        System.out.println(paperRectangle.getColor());
        System.out.println(paperRectangle.getArea());

        Rectangle.PaperRectangle paperRectangle1 = new Rectangle.PaperRectangle(paperRectangle);
        System.out.println(paperRectangle1.getArea());
        System.out.println(paperRectangle1.getColor());
    }
}
