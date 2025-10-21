public class Cube extends Shape {
    private double edge;

    public Cube(double edge) {
        if (edge <= 0) {
            throw new IllegalArgumentException("A aresta deve ser um valor positivo.");
        }
        this.edge = edge;
    }

    @Override
    public double area() {
        return 6 * Math.pow(this.edge, 2);
    }

    @Override
    public double volume() {
        return Math.pow(this.edge, 3);
    }

    @Override
    public String toString() {
        return "Cubo (aresta=" + this.edge + ")";
    }
}
