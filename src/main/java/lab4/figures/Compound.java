package lab4.figures;

import java.util.List;

public class Compound extends Body {
    private List<Body> newFigures;

    Compound(double density, double volume, double mass) {
        super(density, volume, mass);
    }

//    double GetMass();

    boolean AddChildBody(List<String> figures) {
        int count = 0;
        for (String figure: figures) {
            if (figure.equals("cone")) {
                Cone cone = new Cone(0, 0, 0, 0 ,0);
                newFigures.add(cone);
                count++;
            }
            if (figure.equals("cylinder")) {
                Cylinder cylinder = new Cylinder(0, 0, 0, 0 ,0);
                newFigures.add(cylinder);
                count++;
            }
            if (figure.equals("parallelepiped")) {
                Parallelepiped parallelepiped = new Parallelepiped(0, 0, 0, 0 ,0, 0);
                newFigures.add(parallelepiped);
                count++;
            }
            if (figure.equals("sphere")) {
                Sphere sphere = new Sphere(0, 0, 0);
                newFigures.add(sphere);
                count++;
            }
        }
        return count > 0;
    }
}
