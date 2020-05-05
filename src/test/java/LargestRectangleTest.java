import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleTest {

    @Test
    public void test00() {
        int[] input = new int[] {1, 2, 3, 4, 5};

        long area = LargestRectangle.largestRectangle(input);

        assertEquals(9, area);
    }
}