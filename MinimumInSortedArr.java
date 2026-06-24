public class MinimumInSortedArr {
    // public static int minSortedArr(int arr[]){
    // int low = 0;
    // int high = arr.length-1;
    // int ans = Integer.MAX_VALUE;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[low] <= arr[mid]){
    // ans = Math.min(ans, arr[low]);
    // low = mid+1;
    // }
    // else{
    // ans = Math.min(ans, arr[mid]);
    // high = mid-1;
    // }
    // }
    // return ans;
    // }

    // brute force
    /*
     * time complexity: O(N) since we are checking every element at once
     * space complexity: O(1) Constant additional space is used
     * //
     */
    // public static int minSortedArr(int arr[]){
    // int minVal = Integer.MAX_VALUE;
    // for(int i=0; i<arr.length; i++){
    // minVal = Math.min(minVal, arr[i]);
    // }
    // return minVal;
    // }

    // optimal approach
    /*
     * time complexity: O(log N), at every step the search space is reduced to half
     * using bs
     * space complexity: O(1), Constant additional space is used
     */
    // public int minSortedArr(int arr[]){
    // int low = 0;
    // int high = arr.length-1;
    // while(low < high){
    // // int mid = low+(high-low)/2;
    // int mid = (low+high)/2;
    // if(arr[mid] > arr[high]){
    // low = mid+1;
    // }
    // else{
    // high = mid;
    // }
    // }
    // return arr[low];
    // }

    /*
     * time complexity: O(N),since we are checking every element at once
     * space complexity: O(1),constant additional space is used
     */

    // public int minimumSorted(int arr[]){
    // int minVal = Integer.MAX_VALUE;
    // for(int i=0; i<arr.length; i++){
    // minVal = Math.min(minVal, arr[i]);
    // }
    // return minVal;
    // }

    /*
     * time complexity: O(log N)at every step the search space is reduced to half
     * using binary search
     * space complexity: O(1) constant additional space is used
     */

     /*
      * time complexity: O(log N), at every step the search space is reduced to half
      * using binary search
      * space complexity: O(1),constant space is used
      */
    //  public int minimumEle(int arr[]){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low < high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] > arr[high]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid;
    //         }
    //     }
    //     return arr[low];
    //  }

    public int minimumInSorted(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {
        // int arr[] = {5,6,7,1,2,3};
        // // int target = 5;
        // MinimumInSortedArr obj = new MinimumInSortedArr();
        // int result = obj.minSortedArr(arr);
        // System.out.println("The minimum element is: "+result);

        // int arr[] = {5,6,7,1,2,3,4};
        // MinimumInSortedArr obj = new MinimumInSortedArr();
        // int result = obj.minSortedArr(arr);
        // System.out.println("The minimum element is: "+result);

        // int arr[] = {5,6,7,1,2,3,4};
        // MinimumInSortedArr obj = new MinimumInSortedArr();
        // int result = obj.minSortedArr(arr);
        // System.out.println("The minimum element is: "+result);

        // int arr[] = {5,6,7,1,2,3,4};
        // MinimumInSortedArr obj = new MinimumInSortedArr();
        // int result = obj.minimumSorted(arr);
        // System.out.println("The minimum element is: "+result);

        // int arr[] = {4,5,6,7,1,2,3};
        // MinimumInSortedArr obj = new MinimumInSortedArr();
        // int result = obj.minimumEle(arr);
        // System.out.println("The minimum element is: "+result);

        int arr[] = {4,5,6,1,2,3};
        MinimumInSortedArr obj = new MinimumInSortedArr();
        int result = obj.minimumInSorted(arr);
        System.out.println("The minimum element is: "+result);
    }
}
