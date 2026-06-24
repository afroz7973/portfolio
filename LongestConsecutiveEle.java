
import java.util.HashSet;

public class LongestConsecutiveEle {
    // using brute force 
    // time complexity O(N^2) where N is the size of given array
    // space complexity O(1) as we are not using any extra spacce
    // public static boolean linearSearch(int arr[],int num){
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] == num){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public static int longestConsecutive(int arr[]){
    //     int n = arr.length;
    //     int longest = 1;
    //     for(int i=0; i<n; i++){
    //         int x = arr[i];
    //         int cnt = 1;
    //         while(linearSearch(arr, x+1) == true){
    //             x += 1;
    //             cnt += 1;
    //         }
    //         longest = Math.max(longest, cnt);
    //     }
    //     return longest;
    // }

    // using better approach
    /*
     * Time Complexity: O(NlogN) + O(N), N = size of the given array.
     * Reason: O(NlogN) for sorting the array. To find the longest sequence, we are
     * using a loop that results in O(N).
     * 
     * Space Complexity: O(1), as we are not using any extra space to solve this
     * problem.
     */

    // public static int LongestConsecutive(int arr[]){
    //     int n = arr.length;
    //     if(n == 0){
    //         return 0;
    //     }
    //     Arrays.sort(arr);
    //     int lastSmaller = Integer.MIN_VALUE;
    //     int cnt = 0;
    //     int longest = 1;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] - 1 == lastSmaller){
    //             cnt += 1;
    //             lastSmaller = arr[i];

    //         }
    //         else if(lastSmaller != arr[i]){
    //             cnt = 1;
    //             lastSmaller = arr[i];

    //         }
    //         longest = Math.max(longest, cnt);
    //     }
    //     return longest;
    // }

    // using optimal approach

    public static int consecutiveEle(int arr[]){
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int longest = 1;
        HashSet<Integer> sets = new HashSet<>();
        for(int i=0; i<n; i++){
            sets.add(arr[i]);
        }
        for(int it : sets){
            if(!sets.contains(it-1)){
                int cnt = 1;
                int x = it;
                while(sets.contains(x+1)){
                    x = x+1;
                    cnt = cnt+1;

                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;

    }
    public static void main(String[] args) {
        // int arr[] = {100,200,1,2,3,4};
        // int ans = longestConsecutive(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        // int arr[] = {100,200,1,2,3,4};
        // int ans = LongestConsecutive(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        int arr[] = {100,200,1,2,3,4};
        int ans = consecutiveEle(arr);
        System.out.println("The longest consecutive element is: "+ans);
    }
}
