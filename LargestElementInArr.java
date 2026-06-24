public class LargestElementInArr {
    public static int larElement(int[] nums,int n){
        int largest = nums[0]; // suppose 0 is largest
        for(int i=1; i<nums.length; i++){ // starts from 1 since 0 is already largest
            if(nums[i] > largest){
                largest = nums[i]; // change it if bigger is found
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr[] = {5,2,8,4,9};
        int n = arr.length;
        System.out.println(larElement(arr, n));
    }
}
