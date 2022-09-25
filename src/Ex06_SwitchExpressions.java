import java.util.stream.Stream;

/**
 * Demonstrates using a Teeing Collector to perform two actions on a stream
 */
public class Ex06_SwitchExpressions {

    /**
     * Some arbitrary type enumeration
     */
    enum SomeThings {
        THINGY,
        THINGAMABOB,
        THINGAMAGIG,
        EVERYTHINGELSE
    }

    static String explainThings(SomeThings type, int someNumber) {
        String result;

        switch(type) {
            case THINGY:
                result = "As plain as things go: " + (someNumber + 38);
                break;

            case THINGAMABOB:
                result = "Things from bob: " + (someNumber * 2);
                break;

            case THINGAMAGIG:
                result = "When I can't explain some thing: " + (someNumber + 42);
                break;

            case EVERYTHINGELSE:
                result = "... and everyhing else: " + (someNumber * 3);
                break;

            default:
                result = "This should not happen!";
                break;
        }

        return "Thing explanation: " + result;
    }


    /**
     * Runs the demonstration
     * @param args for yarrs truly
     */
    public static void main(String[] args) {
        System.out.println("Example 04: Collectors.teeing() example");

        // Chosen by dice-roll, guaranteed random
        int randomNumber = 4;

        System.out.println(explainThings(SomeThings.THINGY, randomNumber));
        System.out.println(explainThings(SomeThings.THINGAMABOB, randomNumber));
        System.out.println(explainThings(SomeThings.THINGAMAGIG, randomNumber));
        System.out.println(explainThings(SomeThings.EVERYTHINGELSE, randomNumber));
    }
}
