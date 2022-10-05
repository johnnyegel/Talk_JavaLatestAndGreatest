package demo;

import jdk.incubator.concurrent.StructuredTaskScope;

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

    // TODO! Show ShutdownOnSuccess and ShutdownOnFailure
    // https://download.java.net/java/early_access/loom/docs/api/jdk.incubator.concurrent/jdk/incubator/concurrent/StructuredTaskScope.html

    public static void main(String[] args) throws InterruptedException {
        simpleExample();
    }
}
