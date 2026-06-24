import java.util.ArrayList;
import java.util.List;

public class MajorityElementss {
    // brute force
    // time complexity: O(N2) WHERE n is the size of array
    // space complexity:
    // public static List<Integer> majorityElement(int nums[]) {
    // int n = nums.length;
    // List<Integer> lss = new ArrayList<>();
    // for (int i = 0; i < n; i++) {
    // if (lss.size() == 0 || lss.get(0) != nums[i]) {
    // int count = 0;
    // for (int j = 0; j < n; j++) {
    // if (nums[j] == nums[i]) {
    // count++;
    // }
    // }
    // if (count > n / 3) {
    // lss.add(nums[i]);
    // }
    // if (lss.size() == 2) {
    // break;
    // }
    // }
    // }
    // return lss;
    // }

    // better approach
    // time complexity: O(N*logN)
    // public static List<Integer> majorityEle(int nums[]){
    // int n = nums.length;
    // List<Integer> lss = new ArrayList<>();

    // HashMap<Integer,Integer> map = new HashMap<>();
    // int mini = (int)(n/3)+1;
    // for(int i=0; i<n; i++){
    // int value = map.getOrDefault(nums[i], 0);
    // map.put(nums[i], value+1);
    // if(map.get(nums[i]) == mini){
    // lss.add(nums[i]);
    // }
    // if(lss.size() == 2) break;
    // }
    // return lss;
    // }

    // Optimal approach
    /*
     * Time Complexity: O(N) + O(N), where N = size of the given array.
     * Reason: The first O(N) is to calculate the counts and find the expected
     * majority elements. The second one is to check if the calculated elements are
     * the majority ones or not.
     * 
     * Space Complexity: O(1) as we are only using a list that stores a maximum of 2
     * elements. The space used is so small that it can be considered constant.
     */
    public static List<Integer> majorityElement(int nums[]) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1)
                cnt1++;
            else if (nums[i] == ele2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> lss = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        }
        int mini = (int)(n/3)+1;
        if(cnt1 >= mini) lss.add(ele1);
        if(cnt2 >= mini) lss.add(ele2);
        return lss;
    }

    public static void main(String[] args) {
        // int arr[] = { 11, 33, 11, 33, 11, 33 };
        // List<Integer> ans = majorityElement(arr);
        // System.out.print("The majority elements are: ");
        // for (int i = 0; i < ans.size(); i++) {
        // System.out.print(ans.get(i) + " ");
        // }
        // System.out.println();

        // int arr[] = {11,33,11,33,11,33};
        // List<Integer> ans = majorityEle(arr);
        // System.out.print("The majority elements are: ");
        // for(int i=0; i<ans.size(); i++){
        // System.out.print(ans.get(i) + " ");
        // }
        // System.out.println();

        int arr[] = {11,33,11,33,11,33};
        List<Integer> ans = majorityElement(arr);
        System.out.println("The majority elements are: ");
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i) + " ");
        }
        System.out.println();   
    }
}
