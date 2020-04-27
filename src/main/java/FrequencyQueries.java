import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given q queries. Each query is of the form two integers:
 * 1 x : Insert x in your data structure.
 * 2 y : Delete one occurence of y from your data structure, if present.
 * 3 z : Check if any integer is present whose frequency is exactly z. If yes, print 1 else 0.
 */
public class FrequencyQueries {

    /**
     * @param queries 2D array containing the operations.
     * @return an int array consisting of all the outputs of queries of type.
     */
    static List<Integer> freqQuery(int[][] queries) {
        final Map<Integer, Integer> numberToFrequencies = new HashMap<>();
        final Map<Integer, Integer> frequencyCounts = new HashMap<>();
        final List<Integer> result = new LinkedList<>();

        for (int[] query : queries) {
            int operation = query[0];
            int number = query[1];

            if (operation == 3) {
                if (number == 0) {
                    result.add(1);
                }
                result.add(frequencyCounts.containsKey(number) ? 1 : 0);
            } else {
                int oldFrequency = numberToFrequencies.getOrDefault(number, 0);
                int oldFrequencyCount = frequencyCounts.getOrDefault(oldFrequency, 0);

                int newFrequency = (operation == 1) ? oldFrequency + 1 : oldFrequency - 1;
                int newFrequencyCount = frequencyCounts.getOrDefault(newFrequency, 0);

                if (newFrequency < 1) {
                    numberToFrequencies.remove(number);
                } else {
                    numberToFrequencies.put(number, newFrequency);
                }

                if (oldFrequencyCount < 2) {
                    frequencyCounts.remove(oldFrequency);
                } else {
                    frequencyCounts.put(oldFrequency, oldFrequencyCount - 1);
                }

                frequencyCounts.put(newFrequency, newFrequencyCount + 1);
            }
        }
        return result;
    }
}
