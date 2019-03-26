package lab4.figures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Compound extends Body {
    List<Body> compoundFigures = new LinkedList<>();

    Compound(double density, double volume, double mass) {
        super(density, volume, mass);
    }

    @Override
    double GetMass() {
        double compoundMass = 0;
        for (Body figure: compoundFigures) {
            compoundMass += figure.mass;
        }
        if (compoundMass == 0) {
            compoundMass = mass;
        }
        return compoundMass;
    }

    @Override
    double GetVolume() {
        double compoundVolume = 0;
        for (Body figure: compoundFigures) {
            compoundVolume += figure.volume;
        }
        return compoundVolume;
    }

    @Override
    double GetDensity() {
        return GetMass() / GetVolume();
    }

    boolean AddChildBody(Scanner scanner, List<Body> figures, Compound compound) {
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            Body figure = new Body(0,0,0);
            figure = figure.init(scanner, name);
            if(name.equals("exit")) {
                break;
            }
            if (name.equals("compound")) {
                System.out.println("Введите фигуры для составного тела:");
                compound.AddChildBody(scanner, figures, compound);
                density = compound.GetDensity();
                volume = compound.GetVolume();
                mass = compound.GetMass();
            } else {
                figures.add(figure);
                compoundFigures.add(figure);
            }

        }
        return !compoundFigures.isEmpty();
    }

    @Override
    String ToString() {
        return "Compound:" + "\n" +
            "Density: " + density + "\n" +
            "Volume: " + volume + "\n" +
            "Mass: " + mass + "\n"
            ;
    }
}
