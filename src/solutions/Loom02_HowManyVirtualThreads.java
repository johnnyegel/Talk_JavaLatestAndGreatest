package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of how many Virtual Threads in Loom
 */
public class Loom02_HowManyVirtualThreads {
    private static final int MAX_THREADS = 100_000;

    /**
     * Runs the Example
     * @param args In case we meet Pirates
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Loom 02: How many Virtual Threads");

        List<Thread> threadList = new ArrayList<>();

        System.out.println("Starting " + MAX_THREADS + " thread...");
        for (int i = 1; i <= MAX_THREADS; i++) {
            Thread thread = Thread.ofVirtual().factory().newThread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + Thread.currentThread());
                }
            });

            if (i % 1000 == 0) {
                System.out.println("Starting thread " + i + " of " + MAX_THREADS);
            }
            threadList.add(thread);
            thread.start();
        }

        System.out.println("Wait for threads to complete...");

        // Join all the threads for clean shutdown
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                // NO-OP! Ignore this exception
            }
        });

        System.out.println("All done...");
    }
}
