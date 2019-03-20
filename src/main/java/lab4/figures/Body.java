package lab4.figures;

abstract class Body {
    double density;
    double volume;
    double mass;
    double radius;
    double height;

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
        return (density * volume);
    }

    double GetBaseRadius() {
        return radius;
    }

    double GetHeight() {
        return height;
    }

    String ToString() {
        return "Фигура";
    }
}
