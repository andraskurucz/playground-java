import java.util.Stack;

public class LargestRectangle {

    /**
     * Imagine a bar graph. The width of each bar is 1 and the height of each bar is given through an array of Integers.
     * Determine the area of the maximum rectangle that can be drawn within the territory marked by the bars.
     *
     * @param h array of the height of the bars
     * @return area of the largest rectangle that can be formed
     */
    static long largestRectangle(int[] h) {

        long maxSum = 0;

        for (int i = 0; i < h.length; i++) {
            int start = i;
            int end = i;

            while (end < h.length && h[i] <= h[end]) {
                end++;
            }

            while (start >= 0 && h[i] <= h[start]) {
                start--;
            }
            start++;

            int sum = h[i] * (end - start);
            if (sum > maxSum) maxSum = sum;
        }


        return maxSum;
    }
}
