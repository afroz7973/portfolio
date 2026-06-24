public class KadaneAlgorithm {
    // public static long MaxArraySum(int[] arr,int n){
    // long maxi = Long.MIN_VALUE;
    // long sum = 0;
    // for(int i=0; i<n; i++){
    // sum += arr[i];
    // if(sum > maxi){
    // maxi = sum;
    // }
    // if(sum < 0){
    // sum = 0;
    // }
    // }
    // return maxi;
    // }

    // public static long maxSumArray(int arr[], int n) {
    //     long maxi = Long.MIN_VALUE;
    //     long sum = 0;
    //     int start = 0;
    //     int ansStart = -1;
    //     int ansEnd = -1;
    //     for (int i = 0; i < n; i++) {
    //         if (sum == 0)
    //             start = i;
    //         sum += arr[i];
    //         if (sum > maxi) {
    //             maxi = sum;
    //             ansStart = start;
    //             ansEnd = i;
    //         }
    //         if (sum < 0) {
    //             sum = 0;
    //         }
    //     }
    //     System.out.print("The subarray is:[");
    //     for (int i = ansStart; i <= ansEnd; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.print("]\n");
    //     return maxi;
    // }

    public static long sumArray(int arr[],int n){
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i=0; i<n; i++){
            if(sum == 0) start = i;
            sum += arr[i];
            if(sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0){
                sum =0;
            }
        }
        System.out.print("The subarray is: [");
        for(int i=ansStart; i<ansEnd; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]\n");
        return  maxi;
    }

    public static void main(String[] args) {
        // int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        // int n = arr.length;
        // long res = MaxArraySum(arr, n);
        // System.out.println("The maximum subarray sum is: "+res);

        // int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // int n = arr.length;
        // long maxSum = maxSumArray(arr, n);
        // System.out.println("The maximum subarray sum is: " + maxSum);

        int arr[] = {-2,1,9,-3,4,-5,4,9,6};
        int n = arr.length;
        long maxSum = sumArray(arr, n);
        System.out.print("The maximum subarray sum is: "+maxSum);
    }
}
