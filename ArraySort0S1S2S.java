
import java.util.ArrayList;
import java.util.Arrays;


public class ArraySort0S1S2S {
    // public static void sortArray(ArrayList<Integer>arr,int n){
    //     // this is using better approach
    //     // Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0’s, 1’s, 2’s, and second O(N) for placing them correctly in the original array.
    //     // Space Complexity: O(1) as we are not using any extra space.

    //     int cnt0 =0;
    //     int cnt1  = 0;
    //     int cnt2 = 0;
    //     for(int i=0; i<n; i++){
    //         if(arr.get(i) == 0){
    //             cnt0++;
    //         }
    //         else if(arr.get(i) == 1){
    //             cnt1++;
    //         }
    //         else{
    //             cnt2++;
    //         }
    //     }
    //     for(int i=0; i<cnt0; i++){
    //         arr.set(i, 0);
    //     }
    //     for(int i=cnt0; i<cnt0+cnt1; i++){
    //         arr.set(i, 1);
    //     }
    //     for(int i=cnt0+cnt1; i<n; i++){
    //         arr.set(i, 2);
    //     }
    // }

    // using Dutch national flag algorithm
    // The Dutch National Flag algorithm is a three-way partitioning algorithm that
    // sorts an array with three distinct values (like 0, 1, and 2) in a single pass

    public static void sortArray(ArrayList<Integer> arr,int n){
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(arr.get(mid) == 0){
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                low++;
                mid++;
            }
            else if(arr.get(mid) == 1){
                mid++;
            }
            else{
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        // int n = 6;
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2,1,0,1,0,2}));
        // sortArray(arr, n);
        // System.out.print("After sorting: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr.get(i)+" ");
        // }
        // System.out.println();

        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{0,1,2,2,0,1}));
        sortArray(arr, n);
        System.out.print("After sorting array: ");
        for(int i=0; i<n; i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();

    }
}
