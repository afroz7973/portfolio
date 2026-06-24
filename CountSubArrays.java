
import java.util.HashMap;

public class CountSubArrays {
    // brute force
    // time complexity: O(N3) where n is the size of the array
    // space coplexity:O(1) Since we are not using any extea space

    // public static int subArray(int arr[],int n){
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
    // time complexity: O(N2) where n is the size of the array
    // space complexity: 
    // public static int countSubArr(int arr[], int n) {
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

    public static int countSubArray(int arr[],int n){
        HashMap<Integer,Integer>mpp = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        mpp.put(0, 1);
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            int remove = prefixSum - n;

            count += mpp.getOrDefault(remove, 0);
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[] = {4,1,2,3};
        // int n = 6;
        // int count = subArray(arr, n);
        // System.out.println("The number of subarray is: "+count);

        // int arr[] = {3,1,2,4};
        // int n = 6;
        // int count = countSubArr(arr, n);
        // System.out.println("The number of subarray is: " + count);

        int arr[] = {3,1,2,4,2};
        int n = 6;
        int count = countSubArray(arr, n);
        System.out.println("The number of subarray is: "+count);
    }
}
