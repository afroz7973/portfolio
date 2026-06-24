

public class RepeatAndMiss {
    // public int[] repeatAndMiss(int arr[]) {
    //     int n = arr.length;
    //     int repeating = -1;
    //     int missing = -1;
    //     for (int i = 1; i <= n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (arr[j] == i) {
    //                 count++;
    //             }
    //             if (count == 2)
    //                 repeating = i;
    //             else if (count == 0) {
    //                 missing = i;{

    //                 }
    //                 if(repeating != -1 && missing != -1){
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return new int[]{repeating,missing};
    // }

    // better approach

    // public int[] repeatAndMissing(int arr[]){
    //     int n = arr.length;
    //     int hash[] = new int[n+1];
    //     for(int i=0; i<n; i++){
    //         hash[arr[i]]++;
    //     }
    //     int repeatin = -1;
    //     int missing = -1;
    //     for(int i=1; i<=n; i++){
    //         if(hash[i] == 2){
    //             repeatin = i;
    //         }
    //         else if(hash[i] == 0){
    //             missing = i;
    //         }
    //         if(repeatin != -1 && missing != -1){
    //             break;
    //         }
    //     }
    //     return new int[]{repeatin,missing};
    // }

    // optimal approach
    /*
     * time complexity: O(N), wheere N is the size of the array,t
     * his is because we are iterating through array to calculate the sums and sums
     * of square
     * space complexity: O(1), as we are using a constant amount of space or variables, regardless of the input size
     */
    public int[] repeatAndMissing(int arr[]){
        long n = arr.length;
        long SN = (n*(n+1))/2;
        long S2N = (n*(n+1)*(2*n+1))/6;
        long s=0;
        long s2=0;
        for(int i=0; i<n; i++){
            s += arr[i];
            s2 += (long)arr[i]*(long)arr[i];
        }
        long val1 = s-SN;
        long val2 = s2-S2N;
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x-val1;
        return new int[]{(int)x,(int)y};
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 1, 2, 5, 4, 6, 7, 5};
        // RepeatAndMiss obj = new RepeatAndMiss();
        // int result[] = obj.repeatAndMiss(arr);
        // System.out.println("The repeatin and missing elements are: {"+result[0]+","+result[1]+"}");

        // int arr[] = {3,1,2,5,4,6,7,5};
        // RepeatAndMiss obj = new RepeatAndMiss();
        // int result[] = obj.repeatAndMissing(arr);
        // System.out.println("Thr repeating and missing elements are: {"+result[0]+","+result[1]+"}");

        int arr[] = {3,1,2,5,4,6,7,5};
        RepeatAndMiss obj = new RepeatAndMiss();
        int result[] = obj.repeatAndMissing(arr);
        System.out.printf("The repeating and missing nunbers are: {%d,%d}\n",result[0],result[1]);
    }
}
