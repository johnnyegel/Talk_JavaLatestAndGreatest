package demo.solutions;

/**
 * Example of Virtual Threads in Loom
 * WARNING! Requires Special LOOM JDK!
 */
public class Loom01_SimpleVirtualThread {

    /**
     * Runs the Example
     * @param args In case we meet Pirates
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Loom 01: Virtual Thread");

        Thread thread = Thread.ofVirtual().factory().newThread(() -> {
            System.out.println("Hello from thread: [" + Thread.currentThread() + "]");
        });

        System.out.println("Starting thread...");
        thread.start();
        thread.join();

        System.out.println("All done...");
    }
}
