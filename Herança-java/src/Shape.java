public abstract class Shape {
    public abstract double area();

    public abstract double volume();

    @Override
    public String toString() {
        return "Forma: " + this.getClass().getSimpleName();
    }
}

