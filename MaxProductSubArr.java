public class MaxProductSubArr {
    // public int maxProduct(int arr[]){
    //     int n = arr.length;
    //     int prefix = 0;
    //     int suffix = 0;
    //     int ans = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         if(prefix == 0){
    //             prefix = 1;
    //         }
    //         if(suffix == 0){
    //             suffix = 1;
    //         }
    //         prefix *= arr[i];
    //         suffix *= arr[n-i-1];
    //         ans = Math.max(ans, Math.max(prefix, suffix));
    //     }
    //     return ans;
    // }

    // better approach
    /*
     * Time complexity: O(N^2), since we are checking the product of all possible
     * subArrays using two nested loop
     * Space complexity: O(1) , since no extra space is used
     */
    public int maxProduct(int arr[]){
        int maxProd = arr[0];
        for(int i=0; i<arr.length; i++){
            int prod = 1;
            for(int j=i; j<arr.length; j++){
                prod *= arr[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }
    public static void main(String[] args) {
        // int arr[] = {2,3,-4,2};
        // MaxProductSubArr obj = new MaxProductSubArr();
        // System.out.println("The number of maximum product count is: "+obj.maxProduct(arr));

        int arr[] = {2,3,-4,2};
        MaxProductSubArr obj = new MaxProductSubArr();
        System.out.println("The number of maximum product count is: "+obj.maxProduct(arr));
    }
}
