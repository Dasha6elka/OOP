package lab4.figures;

class Sphere extends Body {
    Sphere(double density, double volume, double mass) {
        super(density, volume, mass);
    }

    double GetRadius() {
        double number = (3 * volume) / (4 * Math.PI);
        return Math.pow(number, 1.0 / 3);
    }
}
