import org.junit.jupiter.api.Test;
import utility.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayUtilsTest {
    // Kiểm tra kết quả thực hiện chính xác (Normal)
    @Test
    void sumArrayNormalTest() {
        assertEquals(500500, ArrayUtils.sumArray());
    }

    // Kiểm tra giá trị biên
    @Test
    void sumArrayBoundaryUpperTest() {
        long expected = 1000 * (1000 + 1) / 2;
        assertEquals(expected, ArrayUtils.sumArray());
    }
    // Kiểm tra tính đúng đắn của công thức
    @Test
    void sumArrayMatchesFormulaTest(){
        int n = 1000;
        long expected = (long) n * (n+1) / 2;
        assertEquals(expected, ArrayUtils.sumArray());
    }
    // Kiểm tra tính ổn định của hàm
    @Test
    void sumArrayConsistentTest() {
        long result1 = ArrayUtils.sumArray();
        long result2 = ArrayUtils.sumArray();
        assertEquals(result1, result2);
    }
    // Kiểm tra tổng không bị tràn
    @Test
    void sumArrayDoesNotOverflowTest() {
        long result = ArrayUtils.sumArray();
        assertTrue(result < Long.MAX_VALUE, "Tổng vượt quá phạm vi của kiểu Long");
    }
}
