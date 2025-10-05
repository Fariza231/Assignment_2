package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityTest {

    @Test
    public void testMajorityExists() {
        int[] arr = {3, 3, 4, 2, 3, 3, 3};
        BoyerMooreMajority bm = new BoyerMooreMajority(new PerformanceTracker());
        assertEquals(3, bm.findMajorityElement(arr));
    }

    @Test
    public void testSingleElement() {
        int[] arr = {1};
        BoyerMooreMajority bm = new BoyerMooreMajority(new PerformanceTracker());
        assertEquals(1, bm.findMajorityElement(arr));
    }

    @Test
    public void testNoMajorityThrows() {
        int[] arr = {1, 2, 3, 4};
        BoyerMooreMajority bm = new BoyerMooreMajority(new PerformanceTracker());
        assertThrows(RuntimeException.class, () -> bm.findMajorityElement(arr));
    }

    @Test
    public void testEmptyArrayThrows() {
        int[] arr = {};
        BoyerMooreMajority bm = new BoyerMooreMajority(new PerformanceTracker());
        assertThrows(IllegalArgumentException.class, () -> bm.findMajorityElement(arr));
    }
}