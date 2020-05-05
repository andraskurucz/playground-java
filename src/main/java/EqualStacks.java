import java.util.Stack;

public class EqualStacks {

    /**
     * You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
     * You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
     * Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
     * This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're
     * all the same height, then print the height. The removals must be performed in such a way as to maximize the height.
     * Note: An empty stack is still a stack.
     *
     * @param h0 values of stack0
     * @param h1 values of stack1
     * @param h2 values of stack2
     * @return maximum height of equal stacks
     */
    static int equalStacks(int[] h0, int[] h1, int[] h2) {

        int sum0 = 0, sum1 = 0, sum2 = 0;
        Stack<Integer> stack0 = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = h0.length - 1; i >= 0; i--) {
            stack0.push(h0[i]);
            sum0 += h0[i];
        }

        for (int i = h1.length - 1; i >= 0; i--) {
            stack1.push(h1[i]);
            sum1 += h1[i];
        }

        for (int i = h2.length - 1; i >= 0; i--) {
            stack2.push(h2[i]);
            sum2 += h2[i];
        }

        while (sum0 != sum1 || sum1 != sum2) {

            if (sum0 < sum1 || sum2 < sum1) {
                sum1 -= stack1.pop();
            }
            if (sum0 < sum2 || sum1 < sum2) {
                sum2 -= stack2.pop();
            }

            if (sum1 < sum0 || sum2 < sum0) {
                sum0 -= stack0.pop();
            }
        }

        return sum0;
    }
}
