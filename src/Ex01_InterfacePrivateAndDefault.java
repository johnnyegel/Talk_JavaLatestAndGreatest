/**
 * Example of Interface with private methods
 */
public class Ex01_InterfacePrivateAndDefault {

    /**
     * Interface for providers of numbers
     */
    interface NumberProvider {
        double number();
    }

    /**
     * Provides the best number there is
     */
    static class AnswerToLifeTheUniverseAndEverythingProvider implements NumberProvider {
        @Override
        public double number() {
            return 42;
        }

        double squared() {
            double number = number();
            return number * number;
        }

        double qubed() {
            double number = number();
            return number * number * number;
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
