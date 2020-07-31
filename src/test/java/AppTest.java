import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    public AppTest(){

    }

    public int multiply(int a, int b) {
        int res = a * b;
        return res;
    }

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        AppTest tester = new AppTest(); // MyClass is tested

        // assert statements
        assertEquals(0, tester.multiply(10, 0));
        assertEquals(0, tester.multiply(0, 10));
        assertEquals(0, tester.multiply(0, 0));
    }
}
