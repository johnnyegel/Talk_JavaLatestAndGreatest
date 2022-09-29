import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * Demonstrate async blocking code with Virtual Threads
 */
public class Loom03_AsyncBlockingCode {

    static void sleepRuntimeEx(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int blockingProcess1(int number) {
        sleepRuntimeEx(500);
        return number + 42;
    }

    static String blockingProcess2(int someNumber) {
        sleepRuntimeEx(500);
        return "The number squared: " + (someNumber * someNumber);
    }

    static String blockingProcess3(String ourString) {
        sleepRuntimeEx(1000);
        return "String length: " + ourString.length();
    }

    static void sequentialProcessCode() throws InterruptedException {
        // Make random number
        int number = new Random().nextInt(100);

        // Execute the first blocking process
        int processedNumber = blockingProcess1(number);
        System.out.println("Got number: " + processedNumber);

        // Execute the next blocking process
        String firstResult = blockingProcess2(processedNumber);
        System.out.println("Got string: " + firstResult);

        // Modify the result and execute the final process
        String nextParam = firstResult + ", and then some...";
        String finalResult = blockingProcess3(nextParam);

        // Proudly present the result
        System.out.println("Final string: " + finalResult);
    }

    /* Let's do this async using Completable futures...
    static CompletableFuture<Void> asyncCompletableFutureProcessCode() throws ExecutionException, InterruptedException {
        // Make random number
        int number = new Random().nextInt(100);

        // Execute first blocking process in completable future
        return CompletableFuture.supplyAsync(() -> blockingProcess1(number))
                .thenApply(processedNumber -> {
                    System.out.println("Got number: " + processedNumber);
                    return processedNumber;
                })
                .thenCompose(processedNumber -> CompletableFuture.supplyAsync(
                        () -> blockingProcess2(processedNumber)))
                .thenApply(firstResult -> {
                    System.out.println("Got string: " + firstResult);
                    return firstResult + ", and then some...";
                })
                .thenCompose(nextParam -> CompletableFuture.supplyAsync(
                        () -> blockingProcess3(nextParam)))
                .thenAccept(finalResult -> System.out.println("Final string: " + finalResult));
    }
    //*/

    /**
     * Runs the example
     * @param args or not to args
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Run in a thread
        Thread thread = Thread.ofPlatform().factory().newThread(() -> {
            try {
                System.out.println("Running blocking sequential task...");
                sequentialProcessCode();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Staring task in thread");
        thread.start();
        thread.join();

        // Run our async variant
        /*
        System.out.println("\nStaring async process");
        asyncCompletableFutureProcessCode().get();
        //*/

    }
}
