
import java.util.HashSet;
public class RemoveDuplicate {
    // brute force approach
    // O(n*log(n))+O(n)
    // public static int removeDup(int[] arr){
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i=0; i<arr.length; i++){
    //         set.add(arr[i]);
    //     }
    //     int k = set.size();
    //     int j = 0;
    //     for(int x: set){
    //         arr[j++] = x;
    //     }
    //     return k;
    // }
    // this is optimal approach
    // the time complexity is O(N)
    // The space complexity is O(1)
    public static int isSorted(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        int k = set.size();
        int j =0;
        for(int x:set){
            arr[j++] = x;
        }
        return k;
    }
    public static void main(String[] args) {
        // int arr[] = {1,1,2,2,2,3,3};
        // int n = removeDup(arr);
        // System.out.print("Array after removing duplicates: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        int arr[] = {1,1,2,2,2,3,3,4};
        int n = isSorted(arr);
        System.out.print("Array after removing duplicates: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
