package lab4.figures;

import java.util.Scanner;

class Init {
    static Body init(Scanner scanner, String name, Body figure) {
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
