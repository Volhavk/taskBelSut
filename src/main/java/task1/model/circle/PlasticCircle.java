package task1.model.circle;

import task1.materials.Plastic;

public class PlasticCircle extends Circle implements Plastic {
    public PlasticCircle(double radius) {
        super(radius);
    }

    public PlasticCircle(Plastic plastic){
        super(plastic);
    }
}
