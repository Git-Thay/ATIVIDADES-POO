import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(5.0);
        Shape square = new Square(4.0);
        Shape sphere = new Sphere(3.0);
        Shape cube = new Cube(2.0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);
        shapes.add(sphere);
        shapes.add(cube);

        System.out.println("--- Demonstração de Herança e Polimorfismo ---");

        for (Shape shape : shapes) {
            System.out.println("----------------------------------------");
            System.out.println(shape);
            
            double area = shape.area();
            double volume = shape.volume();

            System.out.printf("Área: %.2f%n", area);
            System.out.printf("Volume: %.2f%n", volume);
        }
    }
}