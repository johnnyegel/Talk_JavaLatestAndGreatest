package demo;

/**
 * Demonstrates local variable inference
 */
public class Ex03_LocalVariableInference {

    /**
     * Interface for all sayers of Hello
     */
    interface HelloSayer {
        void sayHello();
    }

    /**
     * Really useful class
     */
    static class TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo
            implements HelloSayer {

        @Override
        public void sayHello() {
            System.out.println("Well, hello there...");
        }
    }

    /**
     * A very generic class
     * @param <T> The type we are genericing about
     */
    static class ReallyGenericSupperImplementation<T extends HelloSayer> implements HelloSayer {
        private final T _thingamabob;
        public ReallyGenericSupperImplementation(T thingamabob) {
            _thingamabob = thingamabob;
        }

        @Override
        public void sayHello() {
            System.out.println("Hello sir. Let me introduce my generic friend:");
            _thingamabob.sayHello();
        }
    }

    /**
     * Instance creator helper method
     * @return long type declaration you can not escape
     */
    static ReallyGenericSupperImplementation<TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo>
            createGenericInstance() {
        return new ReallyGenericSupperImplementation<>(
                new TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo());
    }

    /**
     * Demonstrates local type inference
     * @param args Because I get yelled at for using var
     */
    public static void main(String[] args) {
        System.out.println("Example 02: Type inference demonstrated");

        TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo instance =
                new TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo();

        ReallyGenericSupperImplementation<TheLongestMostRidiculousClassNameICouldComeUpWithForTypeInferenceDemo>
                anotherInstance = createGenericInstance();

        System.out.println("Asking first instance to say hello:");
        instance.sayHello();
        System.out.println();
        System.out.println("Asking second instance to say hello:");
        anotherInstance.sayHello();
    }
}
