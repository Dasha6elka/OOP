package lab4.figures;

import java.util.*;

public class Main {
    static void initialized(Scanner scanner, List<Body> figures)
    {
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            Body figure = new Body(0,0,0);
            if(name.equals("exit")) {
                break;
            }
            figure = figure.init(scanner, name);
            if (name.equals("compound")) {
                System.out.println("Введите фигуры для составного тела:");
                Compound compound = new Compound(0, 0, 0);
                compound.AddChildBody(scanner, figures, compound);
                Compound comp = new Compound(compound.density, compound.volume, compound.mass);
                figures.add(comp);
            } else {
                figures.add(figure);
            }
        }
    }

    static double greatestMass(List<Double> masses) {
        Collections.sort(masses);
        return masses.get(masses.size() - 1);
    }

    static double getMassInWater(double volume) {
        double densityWater = 1000;
        return densityWater * volume;
    }

    static Double lowestMass(List<Double> massesFigureInWater) {
        Collections.sort(massesFigureInWater);
        return massesFigureInWater.get(0);
    }

    public static void main(String[] argc) {
        List<Body> figures = new LinkedList<>();
        List<Double> masses = new LinkedList<>();
        List<Double> massesFigureInWater = new LinkedList<>();

        System.out.println("Введите фигуры(cone, cylinder, sphere, parallelepiped and compound) и их плотность, объём и массу");
        Scanner scanner = new Scanner(System.in);
        Main.initialized(scanner, figures);

        for (Body figure: figures) {
            String out = figure.ToString();
            System.out.println(out);
        }

        for (Body figure: figures) {
            masses.add(figure.GetMass());
            massesFigureInWater.add(Main.getMassInWater(figure.GetMass()));
        }

        System.out.print("Максимальная масса: ");
        System.out.println(Main.greatestMass(masses));
        System.out.print("Минимальная масса фигуры, погружённой в воду: ");
        System.out.println(Main.lowestMass(massesFigureInWater));
    }
}
