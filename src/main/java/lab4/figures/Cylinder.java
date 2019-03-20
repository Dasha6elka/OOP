package lab4.figures;

class Cylinder extends Body {
    private double radius;
    private double height;

    Cylinder(double density, double volume, double mass, double radius, double height) {
        super(density, volume, mass);
        this.radius = radius;
        this.height = height;
    }

    double GetBaseRadius() {
        radius = Math.sqrt(volume / (Math.PI * height));
        return radius;
    }

    double GetHeight() {
        height = volume / (Math.PI * Math.pow(radius, 2));
        return height;
    }
}
