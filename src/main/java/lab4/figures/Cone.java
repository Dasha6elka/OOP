package lab4.figures;

class Cone extends Body {
    private double height;
    private double radius;

    Cone(double density, double volume, double mass, double height, double radius) {
        super(density, volume, mass);
        this.height = height;
        this.radius = radius;
    }

    double GetBaseRadius() {
        radius = Math.sqrt((3 * volume) / (Math.PI * height));
        return radius;
    }

    double GetHeight() {
        height = (3 * volume) / (Math.PI * Math.pow(radius, 2));
        return height;
    }
}
