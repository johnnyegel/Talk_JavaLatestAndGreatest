package demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Demonstrates using a Teeing Collector to perform two actions on a stream
 */
public class Ex05_CollectorsTeeing {

    /**
     * Helper class to contain our result
     */
    static class SumAndCount {
        private final int _sum;
        private final long _count;

        public SumAndCount(int sum, long count) {
            _sum = sum;
            _count = count;
        }

        @Override
        public String toString() {
            return "Sum: " + _sum + ", Count: " + _count;
        }
    }

    /**
     * Sums and counts the integers in the stream
     * @param integerStream The stream of integers to sum and count
     * @return The resulting Sum and Count
     */
    static SumAndCount sumAndCount(Stream<Integer> integerStream) {
        // Necessary as a stream can be used only once.
        // Need to collect it to something to process it twice.
        List<Integer> intList = integerStream.toList();

        // Sum using stream and summing collector, for demo purposes!
        int sum = intList.stream()
                .collect(Collectors.summingInt(i -> i));

        // Count using stream and counting collector, for demo purposes!
        long count = intList.stream()
                .collect(Collectors.counting());

        return new SumAndCount(sum, count);
    }


    /**
     * Runs the demonstration
     * @param args for arguments
     */
    public static void main(String[] args) {
        System.out.println("Example 05: Collectors.teeing() example");

        // Create a stream of pretty integers
        Stream<Integer> prettyIntegers = Stream.of(1, 3, 9, 2, 42, 12, 7, 19, 32);

        // Sum and count them
        SumAndCount result = sumAndCount(prettyIntegers);
        System.out.println("Result: " + result);
    }
}
