package demo;

/**
 * Demonstrates using Advanced Switch Expression (Third preview in Java 19)
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
        // TODO! Implement some better description on what's the deal!
        return idunno.toString();
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
        System.out.println(explainAnyObject(null));
    }
}
