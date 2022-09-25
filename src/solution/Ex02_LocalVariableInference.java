package solution;

/**
 * Demonstrates local variable inference
 */
public class Ex02_LocalVariableInference {

    /**
     * Really useful class
     */
    static class TheLongestMostRidiculousClassNameICouldComeUpWithForDemonstratingWhereTypeInferenceShines {
        void sayHello() {
            System.out.println("Well, hello there...");
        }
    }

    /**
     * Demonstrates local type inference
     * @param args Because I get yelled at for using var
     */
    public static void main(String[] args) {
        System.out.println("Example 02: Type inference demonstrated");

        // Create an instance
        var instance = new TheLongestMostRidiculousClassNameICouldComeUpWithForDemonstratingWhereTypeInferenceShines();

        System.out.println("Saying hello...");
        instance.sayHello();
    }
}
