package task1.model;

import task1.materials.Material;

import java.io.Serializable;

public abstract class Figure implements Material, Serializable {

    private static final long serialVersionUID = 2L;
    /**
     * Calculation of the area of a shape.
     *
     * @return the area of a share.
     */
    public abstract double getArea();

    /**
     * Calculation of the perimeter of a shape.
     *
     * @return the perimeter of a shape.
     */
    public abstract double getPerimeter();
    /**
     * Created String for a shape.
     *
     * @return String, the corresponding a shape.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

