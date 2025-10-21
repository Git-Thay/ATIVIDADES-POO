public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("O raio deve ser um valor positivo.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "Círculo (raio=" + this.radius + ")";
    }
}