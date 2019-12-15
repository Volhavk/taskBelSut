package task1;

import task1.model.circle.Circle;
import task1.model.Figure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box implements Serializable {

    private List<Figure> listOfFigures = new ArrayList<>(20);

    private void checkCapacity() {
        if (listOfFigures.size() == 20) {
            throw new RuntimeException("capacity limit reached");
        }
    }

    private void checkForDuplicates(Figure figure) {
        if (listOfFigures.stream().anyMatch(figure1 -> figure.equals(figure1))) {
            throw new RuntimeException("Duplicate");
        }
    }

    public void addFigure(Figure figure) {
        checkCapacity();
        checkForDuplicates(figure);
        listOfFigures.add(figure);
    }

    public Figure getFigure(int index) {
        return listOfFigures.get(index);
    }

    public void removeFigure(int index) {
        listOfFigures.remove(index);
    }

    public Figure replaceFigure(int index, Figure figure) {
        removeFigure(index);
        addFigure(figure);
        return figure;
    }

    public Figure findFigureWithParameters(double area, double perimeter) {
        for (Figure figure : listOfFigures) {
            if (figure.getArea() == area && figure.getPerimeter() == perimeter) {
                return figure;
            }
        }
        return null;
    }

    public int getNumberOfFigures() {
        int number = listOfFigures.size();
        return number;
    }

    public double getTotalAres() {
        double totalArea = 0;
        for (Figure figure : listOfFigures) {
            totalArea += figure.getArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (Figure figure : listOfFigures) {
            totalPerimeter += figure.getPerimeter();
        }
        return totalPerimeter;
    }

    public List<Figure> getAllCircles() {
        return listOfFigures.stream()
                .filter(figure -> figure instanceof Circle)
                .collect(Collectors.toList());
    }

    public List<Figure> getAllFigures() {
        return listOfFigures.stream()
                .collect(Collectors.toList());
    }
}
