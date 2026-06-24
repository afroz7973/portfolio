
import java.util.HashMap;

public class SubarrSumK {

    // brute force approach
    /*
     * Time Complexity: O(N3), where N = size of the array.
     * Reason: We are using three nested loops here. Though all are not running for
     * exactly N times, the time complexity will be approximately O(N3).
     * 
     * Space Complexity: O(1) as we are not using any extra space.
     */

    // public static int countSubArr(int arr[],int n){
    // int count = 0;
    // for(int i=0; i<arr.length; i++){
    // for(int j=i; j<arr.length; j++){
    // int sum = 0;
    // for(int k=i; k<arr.length; k++){
    // sum += arr[k];
    // }
    // if(sum == n){
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    // better approach
    // time complexity :O(N^2) Where n is the size of the array
    // reason: we are using two nested loop.As each of them is running for exactly N times, so the time complexity will be O(N^2)
    // space complexity: O(1) since we are not using any extra space
    // public static int printSubArray(int arr[], int n) {
    //     int count = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < arr.length; j++) {
    //             sum += arr[j];
    //             if (sum == n) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // optimal approach

    public static int printSubArr(int arr[],int n){
        HashMap<Integer,Integer> mapp = new HashMap<>();
        mapp.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            int remove = prefixSum - n;
            count += mapp.getOrDefault(remove, 0);

            mapp.put(prefixSum, mapp.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        // int arr[] = {3,1,2,4};
        // int n = 6;
        // int count = countSubArr(arr, n);
        // System.out.println("The number of subarray is: "+count);

        // int arr[] = { 3, 1, 2, 4 };
        // int n = 6;
        // int count = printSubArray(arr, n);
        // System.out.println("The number of subarray is: " + count);

        int arr[] = {3,1,2,4};
        int n = 6;
        int count = printSubArr(arr, n);
        System.out.println("The number of sumarray: "+count);
    }
}
