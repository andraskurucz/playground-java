import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class FrequencyQueriesTest {

    @Test
    public void test01() {
        int[][] input = new int[][]{
                new int[]{1, 5},
                new int[]{1, 6},
                new int[]{3, 2},
                new int[]{1, 10},
                new int[]{1, 10},
                new int[]{1, 6},
                new int[]{2, 5},
                new int[]{3, 2}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(0, 1), actual);
    }

    @Test
    public void test02() {
        int[][] input = new int[][]{
                new int[]{3, 4},
                new int[]{2, 1003},
                new int[]{1, 16},
                new int[]{3, 1}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(0, 1), actual);
    }

    @Test
    public void test03() {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{1, 5},
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{2, 4},
                new int[]{3, 2}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(0, 1, 1), actual);
    }

    @Test
    public void test04() {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{2, 3},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{3, 1},
                new int[]{3, 2}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(1, 0), actual);
    }

    @Test
    public void test05() {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{1, 38},
                new int[]{2, 1},
                new int[]{1, 16},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{1, 64},
                new int[]{3, 1},
                new int[]{3, 2}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(1, 0), actual);
    }

    @Test
    public void test06() {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{1, 38},
                new int[]{2, 1},
                new int[]{1, 16},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{1, 64},
                new int[]{1, 84},
                new int[]{3, 1},
                new int[]{1, 100},
                new int[]{1, 10},
                new int[]{2, 2},
                new int[]{2, 1},
                new int[]{1, 67},
                new int[]{2, 2},
                new int[]{3, 1},
                new int[]{1, 99},
                new int[]{1, 32},
                new int[]{1, 58},
                new int[]{3, 2}
        };

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        assertEquals(Arrays.asList(1, 1, 0), actual);
    }

    @Test
    public void test08() throws IOException {
        testFromResource("input08.txt", "output08.txt");
    }

    @Test
    public void test09() throws IOException {
        testFromResource("input09.txt", "output09.txt");
    }

    @Test
    public void test10() throws IOException {
        testFromResource("input10.txt", "output10.txt");
    }

    @Test
    public void test11() throws IOException {
        testFromResource("input11.txt", "output11.txt");
    }

    @Test
    public void test12() throws IOException {
        testFromResource("input12.txt", "output12.txt");
    }

    private void testFromResource(String inputFileName, String outputFileName) throws IOException {
        int[][] input = parseInput("frequencyQueries/" + inputFileName);

        List<Integer> actual = FrequencyQueries.freqQuery(input);

        List<Integer> expected = parseOutput("frequencyQueries/" + outputFileName);
        assertEquals(expected, actual);
    }

    private int[][] parseInput(String fileName) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            return queries;
        }
    }

    private List<Integer> parseOutput(String fileName) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {

            List<Integer> result = new LinkedList<>();

            for (String line; (line = bufferedReader.readLine()) != null; ) {
                if (!line.isEmpty()) {
                    result.add(Integer.parseInt(line));
                }
            }

            return result;
        }
    }
}