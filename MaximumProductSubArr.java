public class MaximumProductSubArr {
    // brute force
    /*
     * time complexity: O(N^3)
     * Space complexity: O(1)
     */
    // public int maxProductSubArr(int arr[]){
    //     int n = arr.length;
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             int product = 1;
    //             for(int k=i; k<=j; k++){
    //                 product = product*arr[k];
    //             }
    //             max = Math.max(max, product);
    //         }
    //     }
    //     return max;
    // }

    // better approach
    /*
     * Time complexity: O(N^2), we check the product of all possible subarrays using
     * two nested loop
     * space complexity: O(1) since no extra space is used
     */
    // public int maxProduct(int arr[]) {
    //     int maxProd = arr[0];
    //     for (int i = 0; i < arr.length; i++) {
    //         int prod = 1;
    //         for (int j = i; j < arr.length; j++) {
    //             prod *= arr[j];
    //             maxProd = Math.max(maxProd, prod);
    //         }
    //     }
    //     return maxProd;
    // }

    // optimal approach
    /*
     * Time complexity: O(N) Since every element of array is visited
     * Space complexity: O(1) constant number of variable are used
     */
    public int maxProduct(int arr[]){
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = {2,3,-2,4};
        // MaximumProductSubArr obj = new MaximumProductSubArr();
        // int product = obj.maxProductSubArr(arr);
        // System.out.println("The number of maximum product array is: "+product);

        // int arr[] = {2,3,-2,4};
        // MaximumProductSubArr obj = new MaximumProductSubArr();
        // System.out.println("The number of maximum product subarray is: "+obj.maxProduct(arr));

        int arr[] = {2,3,-2,4};
        MaximumProductSubArr obj = new MaximumProductSubArr();
        System.out.println("The number of maximum product subarray is: "+obj.maxProduct(arr));
    }
}
