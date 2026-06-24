
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ThreeSum {
    // time complexity: O(N^3*log of unique triplets) where n is the size of array
    // Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
    // space complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
    // public static List<List<Integer>> SumProb(int arr[], int n) {
    //     HashSet<List<Integer>> sets = new HashSet<>();
        // to check all the possible triplets
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = i + 1; k < n; k++) {
        //             if (arr[i] + arr[j] + arr[k] == 0) {
        //                 List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
        //                 temp.sort(null);
        //                 sets.add(temp);
        //             }
        //         }
        //     }
        // }
        // to store the element in the answer
        // List<List<Integer>> ans = new ArrayList<>(sets);
        // return ans;
    // }


    // using brute force
    // public static List<List<Integer>> triplets(int arr[],int n){
    //     HashSet<List<Integer>> sets = new HashSet<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             for(int k=i+1; k<n; k++){
    //                 if(arr[i]+arr[j]+arr[k] == 0){
    //                     List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
    //                     temp.sort(null);
    //                     sets.add(temp);
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(sets);
    //     return ans;
    // }

    // better approach
    /*
     * Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the
     * array.
     * Reason: Here, we are mainly using 3 nested loops. And inserting triplets into
     * the set takes O(log(no. of unique triplets)) time complexity. But we are not
     * considering the time complexity of sorting as we are just sorting 3 elements
     * every time.
     * 
     * Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a
     * set data structure and a list to store the triplets and extra O(N) for
     * storing the array elements in another set.
     */

    // public static List<List<Integer>> triplets(int arr[],int n){
    //     HashSet<List<Integer>> sets = new HashSet<>();
    //     for(int i=0; i<n; i++){
    //         HashSet<Integer> hash = new HashSet<>();
    //         for(int j=i+1; j<n; j++){
    //             int third = -(arr[i]+arr[j]);
    //             if(hash.contains(third)){
    //                 List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
    //                 temp.sort(null);
    //                 sets.add(temp);
    //             }
    //             hash.add(arr[j]);
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(sets);
    //     return ans;
    // }

    // optimal approach
    /*
     * Time Complexity: O(NlogN)+O(N2), where N = size of the array.
     * Reason: The pointer i, is running for approximately N times. And both the
     * pointers j and k combined can run for approximately N times including the
     * operation of skipping duplicates. So the total time complexity will be O(N2).
     * 
     * Space Complexity: O(no. of quadruplets), This space is only used to store the
     * answer. We are not using any extra space to solve this problem. So, from that
     * perspective, space complexity can be written as O(1).
     */
    public static List<List<Integer>> triplets(int arr[],int n){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i != 0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k-1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int arr[] = { -1, 0, 1, 2, -1, -4 };
        // int n = arr.length;
        // List<List<Integer>> ans = SumProb(arr, n);
        // for (List<Integer> it : ans) {
        //     System.out.print("[");
        //     for (Integer i : it) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.print("] ");
        // }
        // System.out.println();

        // int arr[] = {-1,0,1,2,-1,-4};
        // int n = arr.length;
        // List<List<Integer>> ans = triplets(arr, n);
        // for(List<Integer> it:ans){
        //     System.out.print("[ ");
        //     for(Integer i:it){
        //         System.out.print(i + " ");
        //     }
        //     System.out.print("] ");
        // }
        // System.out.println();

        // int arr[] = {-1,0,1,2,-1,-4};
        // int n = arr.length;
        // List<List<Integer>> ans = triplets(arr, n);
        // for(List<Integer> it:ans){
        //     System.out.print("[ ");
        //     for(Integer i : it){
        //         System.out.print(i + " ");
        //     }
        //     System.out.print("] ");
        // }
        // System.out.println();

        int arr[] = {-1,0,1,2,-1,-4};
        int n = arr.length;
        List<List<Integer>> ans = triplets(arr, n);
        for(List<Integer> it : ans){
            System.out.print("[ ");
            for(Integer i : it){
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
