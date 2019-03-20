package lab4.figures;

class Parallelepiped extends Body {
    private double width;
    private double height;
    private double depth;

    Parallelepiped(double density, double volume, double mass, double width, double height, double depth) {
        super(density, volume, mass);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double GetWidth() {
        width = volume / (height * depth);
        return width;
    }

    double GetHeight() {
        height = volume / (width * depth);
        return height;
    }

    double GetDepth() {
        depth = volume / (width * height);
        return depth;
    }
}
