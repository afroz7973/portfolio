
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSums {
    
    // time complexity: O(N^4) where n is the size of array
    // reason: Here we are using 4 nested loops.but we are not considering the time complexity of sorting as we are just sorting 4 elements every time.
    // Space Complexity: O(2 * no. of the quadruplets) as we are using a set data
    // structure and a list to store the quads.

    // public static List<List<Integer>> fourSome(int nums[],int target){
    
    
    //     int n = nums.length;
    //     HashSet<List<Integer>> sets = new HashSet<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             for(int k=j+1; k<n; k++){
    //                 for(int l=k+1; l<n; l++){
    //                     long sum = (long)nums[i]+(long)nums[j];
    //                     sum += nums[k];
    //                     sum += nums[l];
    //                     if(sum == target){
    //                         List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
    //                         Collections.sort(temp);
    //                         sets.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(sets);
    //     return ans;
    // }


    // time complexity: O(N^3*log(M)), where n is the size of array,M is the no. of elements in set
    // reason: Here,we are using 3 nested loops,inside the nested loop there are some operations on the set data structure which take log(M) time complexity
    /* space complexity:
     * O(2 * no. of the quadruplets)+O(N)
     * Reason: we are using a set data structure and a list to store the quads. This
     * results in the first term. And the second space is taken by the set data
     * structure we are using to store the array elements. At most, the set can
     * contain approximately all the array elements and so the space complexity is
     * O(N).
     */
    
    // public static List<List<Integer>> fourSum(int arr[],int target){

    //     int n = arr.length;
    //     HashSet<List<Integer>> sets = new HashSet<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             HashSet<Long> hashsets = new HashSet<>();
    //             for(int k=j+1; k<n; k++){
    //                 long sum = arr[i]+arr[j];
    //                 sum += arr[k];
    //                 long fourth = target-sum;
    //                 if(hashsets.contains(fourth)){
    //                     List<Integer>temp = new ArrayList<>();
    //                     temp.add(arr[i]);
    //                     temp.add(arr[j]);
    //                     temp.add(arr[k]);
    //                     temp.add((int)fourth);
    //                     temp.sort(Integer::compareTo);
    //                     sets.add(temp);
    //                 }
    //                 hashsets.add((long)arr[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(sets);
    //     return ans;
    // }

    // optimal approach

    /*
     * Time Complexity: O(N3), where N = size of the array.
     * Reason: Each of the pointers i and j, is running for approximately N times.
     * And both the pointers k and l combined can run for approximately N times
     * including the operation of skipping duplicates. So the total time complexity
     * will be O(N3).
     * 
     * Space Complexity: O(no. of quadruplets), This space is only used to store the
     * answer. We are not using any extra space to solve this problem. So, from that
     * perspective, space complexity can be written as O(1).
     */

    public static List<List<Integer>> fourSum(int nums[],int target){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int nums[] = {4,3,3,4,4,2,1,2,1,1};
        // int target = 9;
        // List<List<Integer>> ans = fourSome(nums, target);
        // System.out.print("The quadruplets are: ");
        // for(List<Integer> it:ans){
        //     System.out.print("[ ");
        //     for(Integer i:it){
        //         System.out.print(i + " ");
        //     }
        //     System.out.print("] ");
        // }
        // System.out.println();

        // int arr[] = {4,3,3,4,4,2,1,2,1,1};
        // int target = 9;
        // List<List<Integer>> ans = fourSum(arr, target);
        // System.out.print("The quadruplets are: ");
        // for(List<Integer> it:ans){
        //     System.out.print("[ ");
        //     for(Integer i:it){
        //         System.out.print(i + " ");
        //     }
        //     System.out.print("] ");
        // }
        // System.out.println();

        int nums[] = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.print("The quadruplets are: ");
        for(List<Integer> it:ans){
            System.out.print("[ ");
            for(int ele:it){
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
