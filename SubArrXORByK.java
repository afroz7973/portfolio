
import java.util.HashMap;

public class SubArrXORByK {
    // brute force

    // public static int subarraySum(int arr[],int K){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             int xor = 0;
    //             for(int k=i; k<=j; k++){
    //                 xor = xor^arr[k];
    //             }
    //             if(xor == K) count++;
    //         }
    //     }
    //     return count;
    // }

    // better approach

    // public static int subarray(int arr[],int K){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i=0; i<n; i++){
    //         int xor = 0;
    //         for(int j=i; j<n; j++){
    //             xor = xor^arr[j];
    //             if(xor == K) count++;
    //         }
    //     }
    //     return count;
    // }

    // optimal approach

    public static int subarrayof(int arr[],int K){
        int n = arr.length;
        int xor = 0;
        HashMap<Integer,Integer> mapp = new HashMap<>();
        mapp.put(xor, 1);
        int count = 0;
        for(int i=0; i<n; i++){
            xor = xor^arr[i];
            int x = xor^K;
            if(mapp.containsKey(x)){
                count += mapp.get(x);
            }
            if(mapp.containsKey(xor)){
                mapp.put(xor, mapp.get(xor)+1);
            }
            else{
                mapp.put(xor, 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // int arr[] = {4,2,2,6,4};
        // int k = 6;
        // int result = subarraySum(arr, k);
        // System.out.println("The number of subarrayof k is: "+result);

        // int arr[] = {4,2,2,6,4};
        // int K = 6;
        // int result = subarray(arr, K);
        // System.out.println("The number of subarray of k is: "+result);

        int arr[] = {4,2,2,6,4};
        int K = 6;
        int result = subarrayof(arr, K);
        System.out.println("The number of subarray of k is: "+result);
    }
}
