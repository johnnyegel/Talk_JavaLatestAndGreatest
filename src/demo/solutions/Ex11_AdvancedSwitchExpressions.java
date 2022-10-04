package demo.solutions;

/**
 * Demonstrates using a Teeing Collector to perform two actions on a stream
 */
public class Ex11_AdvancedSwitchExpressions {

    /**
     * Some arbitrary type enumeration
     */
    enum SomeThings {
        THINGY,
        THINGAMABOB,
        THINGAMAGIG,
        EVERYTHINGELSE
    }

    sealed interface Shape permits Triangle, Square {
        double area();
    }

    record Triangle(double width, double height) implements Shape {
        @Override
        public double area() {
            return width * height / 2;
        }
    }

    record Square(double width, double height) implements Shape {
        @Override
        public double area() {
            return width * height;
        }
    }

    static String explainAnyObject(Object idunno) {
        return switch(idunno) {
            case Square square -> "Square square of area: " + square.area();
            case Triangle triangle -> "Triangle area: " + triangle.area();
            case SomeThings t -> "This is a thing: " + t.name();
            default -> "No clue! - " + idunno;
        };
    }

    static String explainAnyObjectMore(Object idunno) {
        return switch(idunno) {
            case Square square && square.area() > 25 -> "Big Square of area: " + square.area();
            case Square square -> "Square square of area: " + square.area();
            case Triangle triangle && triangle.area() < 40 -> "Small Triangle area: " + triangle.area();
            case Triangle triangle -> "Triangle area: " + triangle.area();
            case SomeThings t && t == SomeThings.THINGAMAGIG -> "My favorites: " + t.name();
            case SomeThings t -> "Other stuff: " + t.name();
            default -> "No clue! - " + idunno;
        };
    }

    /**
     * Runs the demonstration
     * @param args for yarrs truly
     */
    public static void main(String[] args) {
        System.out.println("Example 11: Advanced Switch patterns");

        SomeThings thing1 = SomeThings.THINGAMAGIG;
        SomeThings thing2 = SomeThings.THINGY;

        Triangle triangle1 = new Triangle(10, 10);
        Triangle triangle2 = new Triangle(8,5);

        Square square1 = new Square(3, 3);
        Square square2 = new Square(12, 8);

        System.out.println(explainAnyObject(thing1));
        System.out.println(explainAnyObject(thing2));
        System.out.println(explainAnyObject(triangle1));
        System.out.println(explainAnyObject(triangle2));
        System.out.println(explainAnyObject(square1));
        System.out.println(explainAnyObject(square2));

        System.out.println(explainAnyObjectMore(thing1));
        System.out.println(explainAnyObjectMore(thing2));
        System.out.println(explainAnyObjectMore(triangle1));
        System.out.println(explainAnyObjectMore(triangle2));
        System.out.println(explainAnyObjectMore(square1));
        System.out.println(explainAnyObjectMore(square2));

    }
}
