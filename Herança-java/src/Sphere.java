public class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("O raio deve ser um valor positivo.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }

    @Override
    public String toString() {
        return "Esfera (raio=" + this.radius + ")";
    }
}