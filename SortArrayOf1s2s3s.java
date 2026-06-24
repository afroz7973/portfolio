
import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayOf1s2s3s {
    
    // public static void sumArrays(int[] arr,int n){
    //     /*
    //      * Time Complexity: O(N), where N = size of the given array.
    //      * Reason: We are using a single loop that can run at most N times.
    //      * 
    //      * Space Complexity: O(1) as we are not using any extra space.
    //      */
    //     int low = 0;
    //     int mid = 0;
    //     int high = n-1;
    //     while(mid <= high){
    //         if(arr[mid] == 0){
    //             int temp = arr[low];
    //             arr[low] = arr[mid];
    //             arr[mid] = temp;
    //             low++;
    //             mid++;
    //         }
    //         else if(arr[mid] == 1){
    //             mid++;
    //         }
    //         else{
    //             int temp = arr[mid];
    //             arr[mid] = arr[high];
    //             arr[high] = temp;
    //             high--;
    //         }
    //     }
    // }

    // optimal approach
    /*
     * Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for
     * counting the number of 0’s, 1’s, 2’s, and second O(N) for placing them
     * correctly in the original array.
     * 
     * Space Complexity: O(1) as we are not using any extra space.
     */
    
    public static void sortArrays(ArrayList<Integer> arr,int n){
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        for(int i=0; i<n; i++){
            if(arr.get(i) == 0){
                count_0++;
            }
            else if(arr.get(i) == 1){
                count_1++;
            }   
            else{
                count_2++;
            }
        }
        for(int i=0; i<count_0; i++){
            arr.set(i, 0);
        }
        for(int i=count_0; i<count_0+count_1; i++){
            arr.set(i, 1);
        }
        for(int i=count_0+count_1; i<n; i++){
            arr.set(i, 2);
        }
    }
    public static void main(String[] args) {
        // int arr[] = {0,2,1,2,0,1};
        // int n = arr.length;
        // sortArrays(arr, n);
        // System.out.print("The sorted array is: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // int arr[] = {0,2,1,2,0,1};
        // int n = arr.length;
        // sumArrays(arr, n);
        // System.out.print("The sorted array is: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }

        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2,1,2,0,1,0}));
        sortArrays(arr, n);
        System.out.print("Array after sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
}
