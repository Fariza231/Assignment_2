package cli;

import algorithms.BoyerMooreMajority;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10_000, 100_000, 1_000_000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long time = PerformanceTracker.measureExecutionTime(() -> {
                BoyerMooreMajority.findMajority(arr);
            });

            System.out.printf("Size: %d → Time: %d ms%n", size, time);
        }
    }
}
