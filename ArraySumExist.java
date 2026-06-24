public class ArraySumExist {
    
    // using optimal approach
    // time complexity: O(N) where N is the size of array
    // public static String sumExist(int n, int arr[], int target) {
    //     int left = 0;
    //     int right = n - 1;
    //     while (left < right) {
    //         int sum = arr[left] + arr[right];
    //         if (sum == target) {
    //             return "Yes";
    //         } else if (sum < target) {
    //             left++;
    //         } else{
    //             right--;
    //         }
    //     }
    //     return "No";
    // }

    // using variant2 to get the index
    // public static int[] sumArray(int n,int[] arr,int target){
    //     int ans[] = new int[2];
    //     ans[0] = ans[1] = -1;
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[i]+arr[j] == target){
    //                 ans[0] = i;
    //                 ans[1] = j;
    //                 return ans;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public static int[] sumArray(int arr[],int target){
        for(int i=0;i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        // int n = 5;
        // int arr[] = {2,5,6,8,9};
        // int target = 7;
        // String res = sumExist(n, arr, target);
        // System.out.println("This is the answer for the variant1: "+res);

        // int n = 5;
        // int arr[] = {2,6,5,8,11};
        // int target = 14;
        // int[] ans = sumArray(n, arr, target);
        // System.out.println("This is the answer for variant2: [" + ans[0] + ", "+ans[1] + "]");

        // int n = 5;
        int arr[] = {2,5,8,6,7};
        int target = 9;
        int[] ans = sumArray(arr, target);
        System.out.println("This is the answer for variant2: [" + ans[0] + ", "+ans[1] + "]");
    }
}
