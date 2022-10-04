package demo.solutions;

/**
 * Demonstrates Records
 */
public class Ex09_Records {

    record MyData(int number, String stringValue, long length, double probability) { }

    /**
     * Runs the demonstration
     * @param args thy giveth ye
     */
    public static void main(String[] args) {
        System.out.println("Example 09: Records");

        MyData test1 = new MyData(42, "Weeeeee", 128_000, 0.01);
        MyData test2 = new MyData(13, "Ooooh!", 987_654_321, 0.42);
        MyData test3 = new MyData(42, "Weeeeee", 128_000, 0.01);

        System.out.printf("Test1 [%08X]: %s%n", test1.hashCode(), test1);
        System.out.printf("Test2 [%08X]: %s%n", test2.hashCode(), test2);
        System.out.printf("Test3 [%08X]: %s%n", test3.hashCode(), test3);

        System.out.println("Test1 == Test2:" + test1.equals(test2));
        System.out.println("Test1 == Test3:" + test1.equals(test3));

        System.out.println("Test1.number() - " + test1.number());
        System.out.println("Test1.stringValue() - " + test1.stringValue());
        System.out.println("Test1.length() - " + test1.length());
        System.out.println("Test1.probability() - " + test1.probability());
    }
}
