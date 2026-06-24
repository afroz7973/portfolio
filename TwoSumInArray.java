
import java.util.Arrays;

public class TwoSumInArray {
    // Naive Approach(Brute-force approach):
    // Time Complexity: O(N2), where N = size of the array.
    // public static String twoSum(int n,int[]arr, int target){
    // for(int i=0; i<n; i++){
    // for(int j=i+1; j<n; j++){
    // if(arr[i]+arr[j] == target){
    // return "YES";
    // }
    // }
    // }
    // return "No";
    // }

    // public static String arraySum(int n, int arr[], int target) {
    //     // optimal solution
    //     // Time Complexity: O(N) + O(N*logN), where N = size of the array.
    //     // using two pointer
    //     Arrays.sort(arr);
    //     int left = 0;
    //     int right = n - 1;
    //     while (left < right) {
    //         int sum = arr[left] + arr[right];
    //         if (sum == target) {
    //             return "Yes";
    //         } else if (sum < target) {
    //             left++;
    //         } else {
    //             right--;
    //         }
    //     }
    //     return "No";
    // }

    // using hashmap
    /*
     * Time Complexity: O(N), where N = size of the array.
     * Reason: The loop runs N times in the worst case and searching in a hashmap
     * takes O(1) generally. So the time complexity is O(N).
     * 
     */
    // public static int[] arraySums(int[] arr,int target){
    //     int ans[] = new int[2];
    //     ans[0] = ans[1] = -1;
    //     HashMap<Integer,Integer> maps = new HashMap<>();
    //     for(int i=0; i<arr.length; i++){
    //         int num = arr[i];
    //         int moreNeed = target-num;
    //         if(maps.containsKey(moreNeed)){
    //             ans[0] = maps.get(moreNeed);
    //             ans[1] = i;
    //             return ans;
    //         }
    //         maps.put(arr[i], i);
    //     }

    //     return ans;
    // }

    public static int[] arraySumss(int n,int[] arr,int target){
        int ans[][] = new int[n][2];
        for(int i=0; i<n; i++){
            ans[i][0] = arr[i];
            ans[i][1] = i;
        }
        Arrays.sort(ans,(a,b) -> Integer.compare(a[0], b[0]));
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = ans[left][0]+ans[right][0];
            if(sum == target){
                return new int[]{ans[left][1],ans[right][1]};
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        // int n = 5;
        // int arr[] = {5,8,9,1,3};
        // int target = 9;
        // String res = twoSum(n, arr, target);
        // System.out.println("This is for variant 1: "+res);
        // int n = 5;
        // int[] arr = { 5, 8, 9, 7, 1 };
        // int target = 10;
        // String res = arraySum(n, arr, target);
        // System.out.println("This is the answer for varient1: " + res);

        // int arr[] = {2,8,9,7,6};
        // int target = 14;
        // int ans[] = arraySums(arr, target);
        // System.out.println("this is for variant2:["+ ans[0] + ", "+ans[1] + "]");

        int n = 5;
        int arr[] = {2,5,8,9,7};
        int target = 17;
        int ans[] = arraySumss(n, arr, target);
        System.out.println("This is for variant2: [" +ans[0] + ", " +ans[1]+"]");
    }
}
