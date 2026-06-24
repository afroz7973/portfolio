public class RepeatingAndMissing {

    // brute force
    /*
     * Time Complexity: O(N2), where N is the size of the array. This is because we
     * are iterating through the array for each integer from 1 to N, leading to a
     * nested loop.
     * 
     * Space Complexity: O(1), as we are using a constant amount of space for the
     * variables `repeating` and `missing`, regardless of the input size.
     */

    // public int[] repeatAndMiss(int arr[]) {
    //     int n = arr.length;
    //     int repeating = -1;
    //     int missing = -1;
    //     for (int i = 1; i <= n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (arr[j] == i)
    //                 count++;
    //         }
    //         if (count == 2)
    //             repeating = i;

    //         else if (count == 0)
    //             missing = i;

    //         if (repeating != -1 && missing != -1)
    //             break;
    //     }
    //     return new int[] { repeating, missing };
    // }

    // better approoach

    /*
     * time complexity: O(2*N) where n is the size of the array. This is because we
     * are iterating through the array once to build the hash array
     * and then iterating through the hash array to find the repeating and missing
     * numbers.
     * space complexity: O(N) as we are using an additional hash array of size N+1 to store the frequency of each element
     */
    
    // public int[] repeatAndMiss(int arr[]){
    //     int n = arr.length;
    //     int hash[] = new int[n+1];
    //     for(int i=0; i<n; i++){
    //         hash[arr[i]]++;
    //     }
    //     int repeating = -1;
    //     int missing = -1;
    //     for(int i=1; i<=n; i++){
    //         if(hash[i] == 2){
    //             repeating = i;
    //         }
    //         else if(hash[i] == 0){
    //             missing = i;
    //         }
    //         if(repeating != -1 && missing != -1){
    //             break;
    //         }
    //     }
    //     return new int[]{repeating,missing};
    // }

    // optimal approach

    public int[] repeatAndMiss(int[] nums){
        int n = nums.length;
        int SN = (n*(n+1))/2;
        int S2N = (n*(n+1)*(2*n+1))/6;
        int s = 0;
        int s2 = 0;
        for(int i=0; i<n; i++){
            s += nums[i];
            s2 += (long)nums[i]*(long)nums[i];

        }
        long val1 = s-SN;
        long val2 = s2-S2N;
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x-val1;
        return new int[]{(int)x,(int)y};
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 1, 4, 5, 4, 6 };
        // RepeatingAndMissing obj = new RepeatingAndMissing();
        // int result[] = obj.repeatAndMiss(arr);
        // System.out.println("The repeating and missing number are: {" + result[0] + "," + result[1] + "}");

        // int arr[] = { 3, 1, 2, 5, 4, 6, 7, 5};
        // // int arr[] = { 3, 1, 4,5,4,6};
        // RepeatingAndMissing obj = new RepeatingAndMissing();
        // int result[] = obj.repeatAndMiss(arr);
        // System.out.println("The repeating and missing numbers are: {"+result[0]+","+result[1]+"}");

        int nums[] = {3,1,2,5,4,6,7,5};
        RepeatingAndMissing obj = new RepeatingAndMissing();
        int[] result = obj.repeatAndMiss(nums);
        System.out.println("The repeating and missing number are: {"+result[0]+","+result[1]+"}");
    }
}
