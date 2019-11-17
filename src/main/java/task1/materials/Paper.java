package task1.materials;

import task1.model.Color;

public interface Paper extends Material {

    Color paint(Color color);

    Color getColor();
}
