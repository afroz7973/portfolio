
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutations {
    // using optimal approach
    // time complexity: O(N) we find the breaking point and reverse the subarray
    // inlinear time.
    // Space Complexity: O(1), constant additional space is used.

    // public void nextPermutation(int nums[]){
    // int index = -1;
    // for(int i=nums.length-2; i>=0; i--){
    // if(nums[i] < nums[i+1]){
    // index = i;
    // break;
    // }
    // }
    // if(index == -1){
    // reverse(nums,0,nums.length-1);
    // return;
    // }
    // for(int i=nums.length-1; i>index;i--){
    // if(nums[i] > nums[index]){
    // swap(nums,i,index);
    // break;
    // }
    // }
    // reverse(nums,index+1,nums.length-1);
    // }
    // public void reverse(int arr[],int start,int end){
    // while(start < end){
    // swap(arr,start,end);
    // start++;
    // end--;
    // }
    // }

    // public void swap(int arr[],int i,int j){
    // int temp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = temp;
    // }

    // using brute force approach

    /*
     * Time Complexity: O(N!*N), since we are generating all possible permutations,
     * it takes N! time.
     * Space Complexity: O(N!), storing all permutation
     */
    
    public List<Integer> nextPermutation(int nums[]) {
        List<List<Integer>> all = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0, all);
        List<Integer> current = new ArrayList<>();
        for (int num : nums)
            current.add(num);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(current)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }
        return current;
    }

    private void permute(int nums[], int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            all.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, all);
            swap(nums, i, start);
        }
    }

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // int nums[] = {1,2,3};
        // NextPermutations per = new NextPermutations();
        // per.nextPermutation(nums);
        // for(int num: nums){
        // System.out.print(num+" ");
        // }
        // System.out.println();
        NextPermutations nex = new NextPermutations();
        int nums[] = { 1, 2, 3 };

        List<Integer> result = nex.nextPermutation(nums);
        for (int x : result)
            System.out.print(x + " ");
        System.out.println();
    }
}
