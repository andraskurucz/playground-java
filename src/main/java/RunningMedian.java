import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public RunningMedian(int size) {
        minHeap = new PriorityQueue<>(size / 2, Comparator.naturalOrder());
        maxHeap = new PriorityQueue<>(size / 2, Comparator.reverseOrder());
    }

    public void add(int value) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && value > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(value);
            } else {
                maxHeap.offer(value);
            }

        } else {
            if (value < maxHeap.peek()) {

                minHeap.offer(maxHeap.poll());
                maxHeap.offer(value);
            } else {
                minHeap.offer(value);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.size() == 0) return 0.0;

        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
