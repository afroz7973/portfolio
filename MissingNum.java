
public class MissingNum {
    // public static int findMissing(int[] arr,int n){
    // // Time Complexity: O(N), where N = size of array+1.

    // // XOR Approach: more efficient
    // // XOR of array elements
    // // XOR up to [1...N-1]
    
    // int xor1 = 0;
    // int xor2 = 0;
    // int num = n-1;
    // for(int i=0; i<arr.length; i++){
    // xor2 = xor2 ^ arr[i];
    // xor1 = xor1 ^ (i+1);
    // }
    // xor1 = xor1 ^ n; //XOR up to [1...N]
    // return xor1^xor2;
    // }
    // using summation approach
    // (N*(N+1)/2)
    public static int findMissing(int arr[], int N) {
        int sum = (N * (N + 1) / 2);
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += arr[i];
        }
        int misingNum = sum - s2;
        return misingNum;
    }

    public static void main(String[] args) {
        // int arr[] = {1,2,3,5};
        // int n = 5;
        // int missing = findMissing(arr, n);
        // System.out.println("The missing number is: "+missing);

        int arr[] = {1,2,3,5};
        int N = 5;
        int ans = findMissing(arr, N);
        System.out.println("Missing number is: "+ans);
        
    }
}

// Note: Among the optimal approaches, the XOR approach is slightly better than
// the summation one because the term (N * (N+1))/2 used in the summation method
// cannot be stored in an integer if the value of N is big (like 105). In that
// case, we have to use some bigger data types. But we will face no issues like
// this while using the XOR approach.
