package utility;

public class ArrayUtils {
    /**
     * Tính tổng các số nguyên từ 1-1000
     */
    public static long sumArray() {
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        return sum;
    }
}
