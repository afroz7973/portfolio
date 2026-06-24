public class ArraySorted {
    public static boolean isSorted(int[] arr, int n) {
        // this is optimal approach
        // time complexity is O(N)
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 50, 5, 7 };
        int n = arr.length;
        System.out.println(isSorted(arr, n));
    }
}
