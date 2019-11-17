package task1.model.triangle;

import task1.materials.Plastic;

public class PlasticTriangle extends Triangle implements Plastic {

    public PlasticTriangle(double baseOfTriangle, double height) {
        super(baseOfTriangle, height);
    }

        public PlasticTriangle(Plastic plastic){
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
