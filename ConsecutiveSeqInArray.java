
import java.util.HashSet;


public class ConsecutiveSeqInArray {
    // using brute force approach
    // time complexity is:O(N^2)
    
    // public static boolean  linearSearch(int arr[],int num){
    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] == num){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int consecutiveElement(int arr[]){
    //     int n = arr.length;
    //     int longest = 1;
    //     for(int i=0; i<n; i++){
    //         int x = arr[i];
    //         int cnt = 1;
    //         while(linearSearch(arr, n=x+1) == true){
    //             x += 1;
    //             cnt += 1;
    //         }
    //         longest = Math.max(longest, cnt);
    //     }
    //     return longest;
    // }

    // Better approach
    /*
     * Time Complexity: O(NlogN) + O(N), N = size of the given array.
     * Reason: O(NlogN) for sorting the array. To find the longest sequence, we are
     * using a loop that results in O(N).
     */

    // public static int ConsecutiveElement(int arr[]){
    //     int n = arr.length;
    //     if(n == 0){
    //         return 0;
    //     }
    //     Arrays.sort(arr);
    //     int lastSmaller = Integer.MIN_VALUE;
    //     int cnt = 0;
    //     int longest = 1;

    //     for(int i=0; i<n; i++){
    //         if(arr[i]-1 == lastSmaller){
    //             cnt += 1;
    //             lastSmaller = arr[i];
    //         }
    //         else if(arr[i] != lastSmaller){
    //             cnt = 1;
    //             lastSmaller = arr[i];
    //         }
    //         longest = Math.max(longest, cnt);
    //     }
    //     return longest;
    // }

    // optimal approach
    
    public static int ConsecutiveElement(int arr[]){
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
        // int a[] = {100,200,1,3,2,4};
        // int ans = consecutiveEle(a);
        // System.out.println("The longest consecutive element is: "+ans);

        // int arr[] = {100,200,1,2,3,4};
        // int ans = ConsecutiveEle(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        // int arr[] = {100,200,1,2,3,4};
        // int ans = consecutiveElementArr(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        // int arr[] = {100,200,1,3,2,4};
        // int ans = consecutiveElement(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        // int arr[] = {10,20,15,6};
        // int ans = ConsecutiveElement(arr);
        // System.out.println("The longest consecutive element is: "+ans);

        int arr[] = {100,200,1,2,3,8};
        int ans = ConsecutiveElement(arr);
        System.out.println("The longest consecutive element is: "+ans);
    }
}
