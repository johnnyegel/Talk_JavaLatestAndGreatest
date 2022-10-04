package demo.solutions;

/**
 * Demonstrates Instance Of pattern matching
 */
public class Ex08_InstanceOfPatternMatching {

    interface EdgedShape {
        int numberOfSides();
    }

    static final class Circle {
        public boolean isBouncy() {
            return false;
        }
    }

    static final class Triangle implements EdgedShape {
        @Override
        public int numberOfSides() {
            return 3;
        }

        public boolean isSuitableAsHat() {
            return true;
        }
    }

    static final class Square implements EdgedShape {
        @Override
        public int numberOfSides() {
            return 4;
        }
    }

    static String objectInspectOMatic(Object obj) {
        String result = "Inspected " + obj;

        if (obj instanceof EdgedShape shape) {
            result += "\n   Edges: " + shape.numberOfSides();
        }

        if (obj instanceof Triangle shape && shape.isSuitableAsHat()) {
            result += "\n   Is suitable as hat";
        }

        if (obj instanceof Circle shape) {
            result += "\n   Circle bouncyness: " + shape.isBouncy();
        }

        return result;
    }

    /**
     * Runs the demonstration
     * @param args thy giveth ye
     */
    public static void main(String[] args) {
        System.out.println("Example 08: InstanceOf pattern matching");

        System.out.println(objectInspectOMatic(new Circle()));
        System.out.println(objectInspectOMatic(new Square()));
        System.out.println(objectInspectOMatic(new Triangle()));
    }
}
