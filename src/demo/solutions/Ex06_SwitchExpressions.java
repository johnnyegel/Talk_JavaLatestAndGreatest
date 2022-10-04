package demo.solutions;

/**
 * Demonstrates using Switch expressions
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
        return "Thing explanation: " + switch (type) {
            case THINGY -> "As plain as things go: " + (someNumber + 38);
            case THINGAMABOB -> "Things from bob: " + (someNumber * 2);
            case THINGAMAGIG -> "When I can't explain some thing: " + (someNumber + 42);
            case EVERYTHINGELSE -> "... and everyhing else: " + (someNumber * 3);
        };
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
