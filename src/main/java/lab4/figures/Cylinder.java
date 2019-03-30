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

    @Override
    String GetName() {
        return "Cylinder ";
    }

    @Override
    String ToString() {
        return "Cylinder:" + "\n" +
            "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n" +
            "Radius: " + GetBaseRadius() + "\n" +
            "Height: " + GetHeight() + "\n"
            ;
    }
}
