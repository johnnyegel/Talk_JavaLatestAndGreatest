package solutions;

/**
 * Demonstrates the Sealed keyword
 */
public class Ex10_Sealed {

    sealed interface Shape permits EdgedShape, Circle {
        double area();
    }

    abstract static sealed class EdgedShape
            implements Shape
            permits Triangle, Square {
        abstract int edges();

        @Override
        public String toString() {
            return "I've got " + edges() + " edges, and my area is: " + area();
        }
    }

    static final class Triangle extends EdgedShape {
        private final double _width;
        private final double _height;

        public Triangle(double width, double height) {
            _width = width;
            _height = height;
        }

        @Override
        public double area() {
            return _width * _height / 2;
        }

        @Override
        int edges() {
            return 3;
        }
    }

    static final class Square extends EdgedShape {
        private final double _width;
        private final double _height;

        public Square(double width, double height) {
            _width = width;
            _height = height;
        }

        @Override
        public double area() {
            return _width * _height;
        }

        @Override
        int edges() {
            return 4;
        }
    }

    static final class Circle implements Shape {
        private final double _radius;

        public Circle(double radius) {
            _radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * _radius * _radius;
        }
    }

    /* FIXME: DELETE! Not an allowed Shape
    class SquigglyLine implements Shape {

        @Override
        public double area() {
            return 0;
        }
    }
    */

    /**
     * Runs the demonstration
     * @param args is it!
     */
    public static void main(String[] args) {
        System.out.println("Example 10: Sealed classes and interfaces");

        Triangle triangle = new Triangle(10, 20);
        Square square = new Square(5, 15);
        Circle circle = new Circle(3);

        System.out.println("Triangle: " + triangle);
        System.out.println("Square: " + square);
        System.out.println("Circle area: " + circle.area());
    }
}

