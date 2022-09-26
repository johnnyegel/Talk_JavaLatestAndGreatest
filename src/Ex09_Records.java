import java.util.Objects;

/**
 * Demonstrates Records
 */
public class Ex09_Records {

    static final class MyData {
        private int _number;
        private String _stringValue;
        private long _length;
        private double _probability;

        MyData(int number, String stringValue, long length, double probability) {
            _number = number;
            _stringValue = stringValue;
            _length = length;
            _probability = probability;
        }

        int number() {
            return _number;
        }

        String stringValue() {
            return _stringValue;
        }

        long length() {
            return _length;
        }

        double probability() {
            return _probability;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyData myData = (MyData) o;
            return _number == myData._number
                    && _length == myData._length
                    && Double.compare(myData._probability, _probability) == 0
                    && Objects.equals(_stringValue, myData._stringValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(_number, _stringValue, _length, _probability);
        }

        @Override
        public String toString() {
            return "MyData[number=" + number()
                    + ", stringValue=" + stringValue()
                    + ", length=" + length()
                    + ", probability=" + probability() + "]";
        }
    }

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
