package lab4.figures;

import java.util.Scanner;

class Body {
    double density;
    double volume;
    double mass;

    Body(double density, double volume, double mass) {
        this.density = density;
        this.volume = volume;
        this.mass = mass;
    }

    double GetDensity() {
        return this.density;
    }

    double GetVolume() {
        return this.volume;
    }

    double GetMass() {
        return GetDensity() * GetVolume();
    }

    String ToString() {
        return "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n"
        ;
    }

    Body init(Scanner scanner, String name) {
        Body figure = new Body(0,0,0);
        if (name.equals("cone")) {
            figure = new Cone(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1);
        }
        if (name.equals("cylinder")) {
            figure = new Cylinder(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1);
        }
        if (name.equals("sphere")) {
            figure = new Sphere(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        }
        if (name.equals("parallelepiped")) {
            figure = new Parallelepiped(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1, 1);
        }
        return figure;
    }
}
