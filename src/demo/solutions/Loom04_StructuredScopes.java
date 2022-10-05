package demo.solutions;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.ExecutionException;

/**
 * Demonstrates a few variants of structured scopes
 */
public class Loom04_StructuredScopes {

    /**
     * Runs two tasks in parallel, waiting for both to complete
     * @throws InterruptedException if interrupted
     */
    public static void simpleExample() throws InterruptedException {
        // :: Create our structured task scope
        try (var scope = new StructuredTaskScope<>()) {
            var start = System.currentTimeMillis();
            // :: Fork two async tasks
            var future1 = scope.fork(() -> {
                //if (true) throw new AssertionError("Boom!");
                Thread.sleep(1_000);
                System.out.println("task1 end");
                return 1;
            });
            var future2 = scope.fork(() -> {
                Thread.sleep(1_000);
                System.out.println("task2 end");
                return 2;
            });
            var future3 = scope.fork(() -> {
                Thread.sleep(1_000);
                System.out.println("task3 end");
                return 3;
            });

            // :: Wait for tasks to complete, and the use results
            scope.join();
            var end = System.currentTimeMillis();
            System.out.println("elapsed " + (end - start));

            // Sum the results
            var result = future1.resultNow() + future2.resultNow() + future3.resultNow();
            //var result = future2.resultNow() + future3.resultNow();
            System.out.println(result);
        }
    }

    /**
     * Demonstrate StructuredTaskScope.ShutdownOnSuccess
     * @throws InterruptedException
     */
    public static void shutdownOnSuccessExample() throws InterruptedException {
        // :: Create our structured task scope
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
            var start = System.currentTimeMillis();
            // :: Fork two async tasks
            var future1 = scope.fork(() -> {
                if (true) throw new AssertionError("Boom!");
                Thread.sleep(1_000);
                System.out.println("task1 end");
                return 1;
            });
            var future2 = scope.fork(() -> {
                Thread.sleep(1_100);
                System.out.println("task2 end");
                return 2;
            });
            var future3 = scope.fork(() -> {
                Thread.sleep(1_100);
                System.out.println("task3 end");
                return 3;
            });

            // :: Wait for tasks to complete, and the use results
            scope.join();
            var end = System.currentTimeMillis();
            System.out.println("elapsed " + (end - start));

            var result = scope.result();

            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Demonstrate StructuredTaskScope.ShutdownOnFailure
     * @throws InterruptedException
     */
    public static void shutdownOnFailureExample() throws InterruptedException {
        // :: Create our structured task scope
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var start = System.currentTimeMillis();
            // :: Fork two async tasks
            var future1 = scope.fork(() -> {
                if (true) throw new AssertionError("Boom!");
                Thread.sleep(1_000);
                System.out.println("task1 end");
                return 1;
            });
            var future2 = scope.fork(() -> {
                Thread.sleep(1_100);
                System.out.println("task2 end");
                return 2;
            });
            var future3 = scope.fork(() -> {
                Thread.sleep(1_100);
                System.out.println("task3 end");
                return 3;
            });

            // :: Wait for tasks to complete, and the use results
            scope.join();
            var end = System.currentTimeMillis();
            System.out.println("elapsed " + (end - start));

            var result = future2.resultNow() + future3.resultNow();
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //simpleExample();
        //shutdownOnSuccessExample();
        shutdownOnFailureExample();
    }
}
