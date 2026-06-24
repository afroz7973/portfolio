
public class LongestSubArrayK {
    // using better solution
    // Time Complexity: O(N) or O(N*logN) depending on which map data structure we
    // are using, where N = size of the array.

    // public static int longestArray(int arr[],long k){
    // int n = arr.length;
    // HashMap<Long,Integer> sumMap = new HashMap<>();
    // long sum = 0;
    // int maxLen = 0;
    // for(int i=0; i<n; i++){
    // sum += arr[i];
    // if(sum == k){
    // maxLen = Math.max(maxLen, i+1);
    // }
    // long rem = sum-k;
    // if(sumMap.containsKey(rem)){
    // int len = i - sumMap.get(rem);
    // sumMap.put(sum, i);
    // }
    // }
    // return maxLen;
    // }

    // optimal approach
    // using two pointer approach
    // public static int longestSubArray(int[] arr, long k) {
    //     int n = arr.length;
    //     int left = 0;
    //     int right = 0;
    //     long sum = arr[0];
    //     int maxLen = 0;
    //     while (right < n) {
    //         while (left <= right && sum > k) {
    //             sum -= arr[left];
    //             left++;
    //         }
    //         if (sum == k) {
    //             maxLen = Math.max(maxLen, right - left + 1);
    //         }
    //         right++;
    //         if (right < n) {
    //             sum += arr[right];
    //         }
    //     }
    //     return maxLen;
    // }

    public static int longestSubArrays(int[] arr,long k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while(right < n){
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // int[] arr = {2,3,5,1,9};
        // long k = 10;
        // int len = longestArray(arr, k);
        // System.out.println("The longest subArray is: "+len);

        // int arr[] = { 2, 3, 5, 1, 9 };
        // long k = 10;
        // int len = longestSubArray(arr, k);
        // System.out.println("The longest subArray is: " + len);
        int arr[] = {-1,1,1};
        long k = 1;
        int len = longestSubArrays(arr, k);
        System.out.println("The length of longest array is: "+len);
    }
}
