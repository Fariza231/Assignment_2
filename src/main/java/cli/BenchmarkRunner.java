package cli;

import algorithms.BoyerMooreMajority;
import metrics.PerformanceTracker;

public class BenchmarkRunner {

    public static int[] generateMajorityArray(int size, int majorityElement) {
        int[] arr = new int[size];
        int majorityCount = size / 2 + 1;

        for (int i = 0; i < majorityCount; i++) {
            arr[i] = majorityElement;
        }
        for (int i = majorityCount; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};

        System.out.printf("%-10s %-15s %-15s %-20s %-20s%n",
                "Size", "Time (ms)", "Majority Element", "Comparisons", "Array Accesses");

        for (int size : sizes) {
            int[] arr = generateMajorityArray(size, 7);

            PerformanceTracker tracker = new PerformanceTracker();
            BoyerMooreMajority algorithm = new BoyerMooreMajority(tracker);

            try {
                long start = System.nanoTime();
                int result = algorithm.findMajorityElement(arr);
                long end = System.nanoTime();

                System.out.printf("%-10d %-15.4f %-15d %-20d %-20d%n",
                        size,
                        (end - start) / 1_000_000.0,
                        result,
                        tracker.getComparisons(),
                        tracker.getAccesses());

            } catch (RuntimeException e) {
                System.out.printf("%-10d ERROR: %s%n", size, e.getMessage());
            }
        }
    }
}
