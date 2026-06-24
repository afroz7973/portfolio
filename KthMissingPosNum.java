public class KthMissingPosNum {

    // brute force
    /*
     * time ccomplexity: O(N),where N is the size of the array.
     * space complexity: O(1),no extra space is used to solve this problem
     */
    // public int missingPositiveNumber(int arr[], int k) {
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] <= k) {
    // k++;
    // } else {
    // break;
    // }
    // }
    // return k;
    // }

    // optimal approach

    /*
     * time complexity: O(log N),for typical binary search
     * space complexity: O(1),no extra space used to solve this problem
     */
    // public int missingPosNumber(int arr[], int k) {
    //     int low = 0;
    //     int high = arr.length-1;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         int missing = arr[mid] - (mid + 1);
    //         if (missing < k) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return k+high+1;
    // }

    // brute force
    /*
     * time complexity: O(N),where n is the size of array
     * space complexity: O(1),since no extra space used to solve this problem
     */
    // public int missingPosNumber(int arr[],int k){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] <= k){
    //             k++;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return k;
    // }

    // optimal approach

    /*
     * time complexity: O(log n),used for typical binary search
     * space complexity: O(1),since no extra space is used to solve this problem
     */
    // public int missingPosNumber(int arr[],int k){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         int missing = arr[mid]-(mid+1);
    //         if(missing < k){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return high+k+1;
    // }

    // public int missingPosNumber(int arr[],int k){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] <= k){
    //             k++;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return k;
    // }

    public int missingPosNumber(int arr[],int k){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            int missing = arr[mid]-(mid+1);
            if(missing < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high+k+1;
    }
    public static void main(String[] args) {
        int arr[] = { 4, 7, 9, 10 };
        int k = 4;
        KthMissingPosNum obj = new KthMissingPosNum();
        int result = obj.missingPosNumber(arr, k);
        System.out.println("The kth missing number is: " + result);
    }
}
