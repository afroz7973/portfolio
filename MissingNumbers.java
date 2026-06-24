public class MissingNumbers {
    // public static int numberMissing(int[] arr,int n){
    // // this is using brute force approach
    // // Time Complexity: O(N2), where N = size of the array+1.

    // for(int i=1; i<n; i++){
    // int flag = 0;
    // for(int j=0; j<n-1; j++){
    // if(arr[j] == i){
    // flag = 1;
    // break;
    // }
    // }
    // if(flag == 0){
    // return i;
    // }
    // }
    // return -1;
    // }

    // using better approach
    public static int findMissing(int[] arr, int n) {
        int hash[] = new int[n + 1];
        for (int i = 0; i < n - 1; i++)
            hash[arr[i]]++;

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int n = 5;
        // int[] arr = {1,2,3,5};
        // int res = numberMissing(arr, n);
        // System.out.println("Missing number is: "+res);

        int n = 5;
        int[] arr = { 1, 2, 4, 5 };
        int ans = findMissing(arr, n);
        System.out.println("The missing number is: " + ans);
    }
}
