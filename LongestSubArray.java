

public class LongestSubArray {
    // public static int longestSubArr(int arr[],long k){
    //     // Naive Approach (Brute-force approach):
    //     // Time Complexity: O(N3) approx., where N = size of the array.

    //     int n = arr.length;
    //     int len = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             long sum = 0;
    //             for(int K=i; K<=j; K++){
    //                 sum += arr[K];
    //             }
    //             if(sum == k) {
    //                 len = Math.max(len, j - i + 1);
    //             }
    //         }
    //     }
    //     return len;
    // }

    // we can optimize this using two loop
    // Time Complexity: O(N) or O(N*logN) depending on which map data structure we
    // are using, where N = size of the array.
    // Space Complexity: O(N) as we are using a map data structure.

    // public static int LongestSub(int[] arr,long  k){
    //     int n = arr.length;
    //     int len = 0;
    //     for(int i=0; i<n; i++){
    //         long sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum += arr[j];
    //             if(sum == k)
    //                 len = Math.max(len, j-i+1);
    //         }
    //     }
    //     return len;
    // }

    // using two pointer approach
    public static int LongestSubArrayy(int[]arr,long k){
        int n = arr.length; // size of the array.
        int left = 0; // 2 pointers
        int right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while(right < n){
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            // if sum = k, update the maxLen i.e. answer:
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            // Move forward thw right pointer:

            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // int arr[] = {2,3,5,1,9};
        // long k = 10;
        // int len = longestSubArr(arr, k);
        // System.out.println("The longest subarray is: "+len);
        // int arr[] = {2,3,5,1,9};
        // long k = 10;
        // int len = LongestSub(arr, k);
        // System.out.println("The longest subarray is: "+len);
        int[] arr = {2,5,3,4,3};
        int k = 7;
        int res = LongestSubArrayy(arr, k);
        System.out.println("The length of longest array is: "+res);
    }
}

// Time Complexity: O(2*N), where N = size of the given array.
// Space Complexity: O(1) as we are not using any extra space.
