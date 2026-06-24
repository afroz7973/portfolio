public class RotateArray {
    // public static void arrRotate(int[] arr, int n){
        // this is rotation for 1 
        // this is brute force 
        // time complexty: O(n), as we iterate through the array only once.
        // space complexity: O(n) as we are using another array of size, same as the
        // given array.

    //     int[] temp = new int[n];
    //     for(int i=1; i<n; i++){
    //         temp[i-1] = arr[i];
    //     }
    //     temp[n-1] = arr[0];
    //     for(int i=0; i<n; i++){
    //         System.out.print(temp[i]+" ");
    //     }
    // }

    public static void arrRotate(int[] arr,int n){
        int temp = arr[0];
        for(int i=1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3,4,5};
        // int n = arr.length;
        // arrRotate(arr, n);
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        arrRotate(arr, n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
