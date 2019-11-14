package task1;

import task1.circle.Circle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Box {

    private List<Figure> listOfFigures = new ArrayList<>(20);

    private void checkCapacity() {
        if (listOfFigures.size() == 20) {
            throw new RuntimeException("capacity limit reached");
        }

    }

    public void addFigure(Figure figure) {
        checkCapacity();
        listOfFigures.add(figure);
    }

    public void removeFigure(int index) {
        listOfFigures.remove(index);
    }

    public List<Figure> getAllCircles() {
        return listOfFigures.stream()
                .filter(figure -> figure instanceof Circle)
                .collect(Collectors.toList());
    }

}
