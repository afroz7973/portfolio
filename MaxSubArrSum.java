public class MaxSubArrSum {
    // using brute force
    // time complexity: O(N3) where n is the size of array
    // space complexity is: O(1) we are not using any extra space
    // public static int maxArraySum(int arr[],int n){
    // int maxi = Integer.MIN_VALUE;
    // for(int i=0; i<n; i++){
    // for(int j=i; j<n; j++){
    // int sum = 0;
    // for(int k=i; k<=j; k++){
    // sum += arr[k];
    // }
    // maxi = Math.max( maxi,sum);
    // }
    // }
    // return maxi;
    // }

    // better approach
    // public static int maxSumArr(int arr[],int n){
    // int maxi = Integer.MIN_VALUE;
    // for(int i=0; i<n; i++){
    // int sum = 0;
    // for(int j=i; j<n; j++){
    // sum += arr[j];
    // }
    // maxi = Math.max(maxi, sum);
    // }
    // return maxi;
    // }

    // using optimal approach
    // public static long maxSubArray(int[] arr,int n){
    // long maxi = Long.MIN_VALUE;
    // long sum = 0;
    // for(int i=0; i<n; i++){
    // sum += arr[i];
    // if(sum > maxi){
    // maxi = sum;
    // }
    // if(sum < 0){
    // sum=0;
    // }
    // }
    // return maxi;
    // }

    // follow up question
    // to find maximum sum array

    public static long maxArraySum(int arr[], int n) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }

        }
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
        return maxi;
    }

    public static void main(String[] args) {
        // int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // int n = arr.length;
        // int maxSum = maxArraySum(arr, n);
        // System.out.println("The maximum subarray sum is: "+maxSum);
        // int arr[] = {-2,1,3,-5,9,6,4,-6};
        // int n = arr.length;
        // int maxSum = maxSumArr(arr, n);
        // System.out.println("The maximum subarray sum is: "+maxSum);

        // int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        // int n = arr.length;
        // long maxSum = maxSubArray(arr, n);
        // System.out.println("The maximum subarray sum is: "+maxSum);

        int arr[] = { 2, 5, -3, 9, 7, 6, 7, 2 };
        int n = arr.length;
        long maxSumm = maxArraySum(arr, n);
        System.out.print("The maximum subarray sum is: " + maxSumm);
    }
}
