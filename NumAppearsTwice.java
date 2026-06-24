public class NumAppearsTwice {
    // public static int getSingle(int[] arr){
    // brute force 
    // Time Complexity: O(N2), where N = size of the given array.

    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         int num = arr[i];
    //         int count = 0;
    //         for(int j=0; j<n; j++){
    //             if(arr[j] == num){
    //                 count++;
    //             }
    //         }
    //         if(count == 1){
    //             return num;
    //         }
    //     }
    //     return -1;
    // }

    // using better approach
    // Time Complexity: O(N)+O(N)+O(N), where N = size of the array

    public static int singleGet(int[] arr){
        int n = arr.length;
        int maxi = arr[0];
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        int hash[] = new int[maxi+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        for(int i=0; i<n; i++){
            if(hash[arr[i]] == 1){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int arr[] = {5,4,1,2,1,2};
        // int n = arr.length;
        // int res = getSingle(arr);
        // System.out.println("The single element is: "+res);

        int arr[] = {4,1,2,1,2};
        int n = arr.length;
        int res = singleGet(arr);
        System.out.println("Single element is: "+res);
    }
}
