public class HoarePartition {

    public static int partition(int[] arr, int low, int high) {

        // pivot is first element here in Hoare
        int pivot = arr[low];

        // i goes to the right, j is left
        int i = low - 1;
        int j = high + 1;

        while (true) {

            // move i + j right/left depending on pivot
            do { i++; } while (arr[i] < pivot);
            do { j--; } while (arr[j] > pivot);

            // hoare complete if they cross
            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    // swaps 2 diff elements in the array
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // main method for test
    public static void main(String[] args) {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int j = partition(arr, 0, arr.length - 1);

        System.out.println("Partition index: " + j);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}