package lab4.figures;

import java.util.*;

public class Main {
    private static void initialized(Scanner scanner, Map<String, List<Double>> figures)
    {
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            if(name.equals("exit") || name.equals("compound")) {
                break;
            }
            double density = scanner.nextDouble();
            double volume = scanner.nextDouble();
            double mass = scanner.nextDouble();
            List<Double> items = new LinkedList<>();
            items.add(density);
            items.add(volume);
            items.add(mass);
            figures.put(name, items);
        }
    }

    private static void getMainParams(Body figure) {
        System.out.print("Density: ");
        System.out.println(figure.GetDensity());
        System.out.print("Volume: ");
        System.out.println(figure.GetVolume());
        System.out.print("Mass: ");
        System.out.println(figure.GetMass());
    }

    private static void getMainWithExtraParams(Body figure) {
        Main.getMainParams(figure);
        System.out.print("Height: ");
        System.out.println(figure.GetHeight());
        System.out.print("Radius: ");
        System.out.println(figure.GetBaseRadius());
        System.out.println();
    }

    private static void greatestMass(List<Double> masses) {
        Collections.sort(masses);
        System.out.print("Максимальная масса: ");
        System.out.println(masses.get(masses.size() - 1));
    }

    private static double getMass(double volume) {
        double densityWater = 1000;
        return densityWater * volume;
    }

    private static void lowestMass(List<Double> massesFigureInWater) {
        Collections.sort(massesFigureInWater);
        System.out.print("Минимальная масса фигуры, погружённой в воду: ");
        System.out.println(massesFigureInWater.get(0));
    }

    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> figures = new HashMap<>();
        List<Double> masses = new LinkedList<>();
        List<Double> massesFigureInWater = new LinkedList<>();

        System.out.println("Введите фигуры(cone, cylinder, sphere, parallelepiped and compound)");
        System.out.println("и их плотность, объём и массу");
        Main.initialized(scanner, figures);

        figures.forEach((key, items) -> {
            if (key.equals("cone")) {
                System.out.println("Cone: ");
                Cone cone = new Cone(items.get(0), items.get(1), items.get(2), 1, 1);
                Main.getMainWithExtraParams(cone);
                masses.add(cone.GetMass());
                massesFigureInWater.add(Main.getMass(items.get(1)));
            }
            if (key.equals("cylinder")) {
                System.out.println("Cylinder: ");
                Cylinder cylinder = new Cylinder(items.get(0), items.get(1), items.get(2), 1, 1);
                Main.getMainWithExtraParams(cylinder);
                masses.add(cylinder.GetMass());
                massesFigureInWater.add(Main.getMass(items.get(1)));
            }
            if (key.equals("parallelepiped")) {
                System.out.println("Parallelepiped: ");
                Parallelepiped parallelepiped = new Parallelepiped(items.get(0), items.get(1), items.get(2), 1, 1, 1);
                Main.getMainParams(parallelepiped);
                System.out.print("Depth: ");
                System.out.println(parallelepiped.GetDepth());
                System.out.print("Height: ");
                System.out.println(parallelepiped.GetHeight());
                System.out.print("Width: ");
                System.out.println(parallelepiped.GetWidth());
                System.out.println();
                masses.add(parallelepiped.GetMass());
                massesFigureInWater.add(Main.getMass(items.get(1)));
            }
            if (key.equals("sphere")) {
                System.out.println("Sphere: ");
                Sphere sphere = new Sphere(items.get(0), items.get(1), items.get(2));
                Main.getMainParams(sphere);
                System.out.println();
                masses.add(sphere.GetMass());
                massesFigureInWater.add(Main.getMass(items.get(1)));
            }
        });

        Main.greatestMass(masses);
        Main.lowestMass(massesFigureInWater);
    }
}
