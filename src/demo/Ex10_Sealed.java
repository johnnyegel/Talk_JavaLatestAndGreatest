package demo;

import java.util.Objects;

/**
 * Demonstrates the Sealed keyword
 */
public class Ex10_Sealed {

    interface Shape {
        double area();
    }

    abstract static class EdgedShape implements Shape {
        abstract int edges();

        @Override
        public String toString() {
            return "I've got " + edges() + " edges, and my area is: " + area();
        }
    }

    static class Triangle extends EdgedShape {
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

    static class Square extends EdgedShape {
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

    // TODO: Implement Circle to extend EdgedShape
    // FIXME! Circle is not an Edged Shape, so this should not be allowed!
    // TODO: Implement SquigglyLine
    // FIXME! SquigglyLines is not a Shape. Should not extend anything here!

    /**
     * Runs the demonstration
     * @param args is it!
     */
    public static void main(String[] args) {
        System.out.println("Example 10: Sealed classes and interfaces");

        Triangle triangle = new Triangle(10, 20);
        Square square = new Square(5, 15);

        System.out.println("Triangle: " + triangle);
        System.out.println("Square: " + square);
    }
}

