import org.junit.Test;

import static org.junit.Assert.*;

public class EqualStacksTest {

    @Test
    public void test00() {
        int[] stack0 = new int[]{3, 2, 1, 1, 1};
        int[] stack1 = new int[]{4, 3, 2};
        int[] stack2 = new int[]{1, 1, 4, 1};

        int steps = EqualStacks.equalStacks(stack0, stack1, stack2);

        assertEquals(5, steps);
    }
}