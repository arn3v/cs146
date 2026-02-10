import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class LomutoPartitionTest {

    // for testing the lomuto partition on an already sorted array
    @Test
    public void testSortedArrayProvided() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int[] before = Arrays.copyOf(arr, arr.length);

        int p = LomutoPartition.partition(arr, 0, arr.length - 1);
        assertTrue(p >= 0 && p < arr.length);

        assertLomutoProperty(arr, 0, arr.length - 1, p);
        assertSameMultiset(before, arr);
    }

    // for when its behavior input array is empty
    @Test
    public void testEmptyArrayProvided() {
        int[] arr = {};
        assertThrows(Exception.class, () -> LomutoPartition.partition(arr, 0, 0));
    }

    // for unsorted array
    @Test
    public void testUnsortedArrayProvided() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};
        int[] before = Arrays.copyOf(arr, arr.length);

        int p = LomutoPartition.partition(arr, 0, arr.length - 1);
        assertTrue(p >= 0 && p < arr.length);

        assertLomutoProperty(arr, 0, arr.length - 1, p);
        assertSameMultiset(before, arr);
    }

    // making sure it actually applies lomuto
    private static void assertLomutoProperty(int[] arr, int low, int high, int p) {
        int pivot = arr[p];
        for (int i = low; i < p; i++) assertTrue(arr[i] <= pivot);
        for (int i = p + 1; i <= high; i++) assertTrue(arr[i] > pivot);
    }

    // for other tests - checking if they don't remove any elements
    private static void assertSameMultiset(int[] before, int[] after) {
        int[] b = Arrays.copyOf(before, before.length);
        int[] a = Arrays.copyOf(after, after.length);
        Arrays.sort(b);
        Arrays.sort(a);
        assertArrayEquals(b, a);
    }
}