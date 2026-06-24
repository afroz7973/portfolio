public class SortedArr {
    // brute force
    // time complexity is O(N^2)
    // public static boolean isSorted(int[] arr, int n){
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[j] < arr[i])
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static boolean isSorted(int[] arr, int n){
        for(int i=1; i<n; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // int arr[] = {1,5,8,9,10};
        // int n = arr.length;
        // System.out.println(isSorted(arr, n));
        int arr[] = {1,5,6,8,9,9};
        int n = arr.length;
        System.out.println(isSorted(arr, n));
    }
}
