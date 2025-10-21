public class Square extends Shape2D {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("O lado deve ser um valor positivo.");
        }
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Quadrado (lado=" + this.side + ")";
    }
}