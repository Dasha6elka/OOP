package lab4.figures;

class Sphere extends Body {
    Sphere(double density, double volume, double mass) {
        super(density, volume, mass);
    }

    double GetRadius() {
        double number = (3 * volume) / (4 * Math.PI);
        return Math.pow(number, 1.0 / 3);
    }

    @Override
    String ToString() {
        return "Sphere:" + "\n" +
            "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n" +
            "Radius: " + GetRadius() + "\n"
            ;
    }
}
