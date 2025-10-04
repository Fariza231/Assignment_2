package algorithms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BoyerMooreMajorityTest {
    @Test
    void testMajorityExists() {
        int[] arr = {3, 3, 4, 2, 3, 3, 5, 3};
        assertEquals(3, BoyerMooreMajority.findMajority(arr));
    }
    @Test
    void testNoMajority() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(-1, BoyerMooreMajority.findMajority(arr));
    }
    @Test
    void testSingleElement() {
        int[] arr = {7};
        assertEquals(7, BoyerMooreMajority.findMajority(arr));
    }
    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BoyerMooreMajority.findMajority(arr));
    }
}
