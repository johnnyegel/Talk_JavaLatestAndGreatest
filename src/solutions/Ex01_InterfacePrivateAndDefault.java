package solutions;

/**
 * Example of Interface with private methods
 */
public class Ex01_InterfacePrivateAndDefault {

    /**
     * Interface for providers of numbers
     */
    interface NumberProvider {
        double number();

        default double squared() {
            return raisedToPower(2);
        }

        default double qubed() {
            return raisedToPower(3);
        }

        private double raisedToPower(int power) {
            return Math.pow(number(), power);
        }
    }

    /**
     * Provides the best number there is
     */
    static class AnswerToLifeTheUniverseAndEverythingProvider implements NumberProvider {
        @Override
        public double number() {
            return 42;
        }
    }

    /**
     * Runs the Example
     * @param args In case we meet Pirates
     */
    public static void main(String[] args) {
        System.out.println("Example 01: Default, static and private interface methods");

        AnswerToLifeTheUniverseAndEverythingProvider provider = new AnswerToLifeTheUniverseAndEverythingProvider();
        System.out.println("- The best number: " + provider.number());
        System.out.println("- The best number squared: " + provider.squared());
        System.out.println("- The best number qubed: " + provider.qubed());

    }
}
