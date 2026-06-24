
import java.util.HashMap;

public class SubArrCountxor {


    // brute force approach
    // time complexity: O(N3) approax.. where N is the size of the array
    // reason: we are using three nested loop where each loop is running approaximately N times
    // space complexity: O(1), since we are not using any extra space
    // public static int countSubArray(int arr[],int k){
    //     int n = arr.length;
    //     int cnt = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             int xorr = 0;
    //             for(int K=i; K<=j; K++){
    //                 xorr = xorr^arr[K];
    //             }
    //             if(xorr == k) cnt++;
    //         }
    //     }
    //     return cnt;
    // }

    // better approach

    // public static int subarray(int arr[],int k){
    //     int n = arr.length;
    //     int cnt = 0;
    //     for(int i=0; i<n; i++){
    //         int xor = 0;
    //         for(int j=i; j<n; j++){
    //             xor = xor^arr[j];
    //             if(xor == k) cnt++;
    //         }
    //     }
    //     return cnt;
    // }

    // optimal approach
    /*
     * Time Complexity: O(N) or O(N*logN) depending on which map data structure we
     * are using, where N = size of the array.
     * 
     * 
     */
    public static int subarray(int arr[],int k){
        int n = arr.length;
        int xr = 0;
        HashMap<Integer,Integer> mapp = new HashMap<>();
        mapp.put(xr, 1);
        int cnt = 0;
        for(int i=0; i<n; i++){
            xr = xr^arr[i];
            int x = xr^k;
            if(mapp.containsKey(x)){
                cnt += mapp.get(x);
            }
            if(mapp.containsKey(xr)){
                mapp.put(xr, mapp.get(xr)+1);
            }
            else{
                mapp.put(xr, 1);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        // int arr[] = {4,2,2,6,4};
        // int k = 6;
        // int result = countSubArray(arr, k);
        // System.out.println("The number of subarray with xor k is: "+result);

        // int arr[] = {4,2,2,6,4};
        // int k = 6;
        // int ans = subarray(arr, k);
        // System.out.println("The number of subarray with xor k is: "+ans);

        int arr[] = {4,2,2,6,4};
        int k = 6;
        int ans = subarray(arr, k);
        System.out.println("The number of subarray of k is: "+ans);
    }
}
