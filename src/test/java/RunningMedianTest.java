import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertArrayEquals;

public class RunningMedianTest {

    @Test
    public void test01() {
        int[] input = new int[]{12, 4, 5, 3, 8, 7};
        double[] expected = new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0};

        double[] actual = runningMedian(input);

        assertArrayEquals(expected, actual, 0.1);
    }

    @Test
    public void test03() throws IOException {
        testFromResource("input03.txt", "output03.txt");
    }

    @Test
    public void test06() throws IOException {
        testFromResource("input06.txt", "output06.txt");
    }

    @Test
    public void test09() throws IOException {
        testFromResource("input09.txt", "output09.txt");
    }

    private void testFromResource(String inputFileName, String outputFileName) throws IOException {
        int[] input = parseInput("runningMedian/" + inputFileName);
        double[] expected = parseOutput("runningMedian/" + outputFileName, input.length);

        double[] actual = runningMedian(input);

        assertArrayEquals(expected, actual, 0.1);
    }

    private double[] runningMedian(int[] input) {
        RunningMedian runningMedian = new RunningMedian(input.length);
        double[] result = new double[input.length];

        for (int i = 0; i < input.length; i++) {
            runningMedian.add(input[i]);
            result[i] = runningMedian.getMedian();
        }

        return result;
    }

    private int[] parseInput(String fileName) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int[] input = new int[n];

            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(bufferedReader.readLine());
            }

            return input;
        }
    }

    private double[] parseOutput(String fileName, int size) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {

            double[] result = new double[size];

            for (int i = 0; i < size; i++) {
                result[i] = Double.parseDouble(bufferedReader.readLine());
            }

            return result;
        }
    }
}