public class LomutoPartition {

    public static int partition(int[] arr, int low, int high) {

        // pivot is last element
        int pivot = arr[high];

        // i keeps track of element boundary for the pivot
        int i = low - 1;

        // for loop to go thru array, starts at lowest j
        for (int j = low; j < high; j++) {

            // if lomuto needs to be implemented and element goes left
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // update and return pivot's new position
        swap(arr, i + 1, high);
        return i + 1;
    }

    //swaps/rearranges elements in lomuto
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //main method to test
    public static void main(String[] args) {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int p = partition(arr, 0, arr.length - 1);

        System.out.println("Pivot index: " + p);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}