package algorithms;

import metrics.PerformanceTracker;

public class BoyerMooreMajority {
    private final PerformanceTracker tracker;

    public BoyerMooreMajority(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public int findMajorityElement(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array cannot be null or empty.");

        int candidate = -1;
        int count = 0;

        for (int num : arr) {
            tracker.incrementAccess();
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
            tracker.incrementComparison();
        }

        int occurrence = 0;
        for (int num : arr) {
            tracker.incrementAccess();
            if (num == candidate) {
                occurrence++;
                tracker.incrementComparison();
            }
        }

        if (occurrence > arr.length / 2) {
            return candidate;
        } else {
            throw new RuntimeException("No majority element found.");
        }
    }
}