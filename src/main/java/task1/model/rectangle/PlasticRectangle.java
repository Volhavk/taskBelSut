package task1.model.rectangle;

import task1.materials.Plastic;

public class PlasticRectangle extends Rectangle implements Plastic {

    public PlasticRectangle(int length, int width) {
        super(length, width);
    }

    public PlasticRectangle(Plastic plastic) {
        super(plastic);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }
}
