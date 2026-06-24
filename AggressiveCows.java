import java.util.Arrays;
public class AggressiveCows {
    // brute force

    /*
     * time complexity;O(logN)+O(N*(max(arr[])-min(arr[]))),where N is the size of
     * the array,max(arr[]) = maximum element in the array,min(arr[])= minimum
     * element in the array
     * space complexity: O(1), as we are not using any extra space to solve this problem
     */

    // public boolean canPlaceCows(int arr[],int cows,int d){
    //     int count = 1;
    //     int lastPos = arr[0];
    //     for(int i=1; i<arr.length; i++){
    //         if(arr[i] - lastPos >= d){
    //             count++;
    //             lastPos = arr[i];
    //         }
    //         if(count >= cows) return true;
    //     }
    //     return false;
    // }

    // public int aggressiveCowss(int arr[],int cows){
    //     Arrays.sort(arr);
    //     int maxDist = arr[arr.length-1]-arr[0];
    //     int ans = 0;
    //     for(int d=1; d<=maxDist; d++){
    //         if(canPlaceCows(arr, cows, d)){
    //             ans = d;
    //         }
    //     }
    //     return ans;
    // }

    // optimal approach

    /*
     * time complexity: O(Nlog N)+log(max(arr[]-min(arr[]))), where max(arr[] is the
     * maximum element in arr[],min(arr[]) is the minimum element in the array)
     * space complexity: O(1),since no extra space is used to solve this problem
     */
    public boolean canPlace(int arr[],int cow,int d){
        int count = 1;
        int lastPos = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] - lastPos >= d){
                count++;
                lastPos = arr[i];
            }
            if(count >= cow) return true;
        }
        return false;
    }

    public int aggressiveCowss(int arr[],int k){
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length-1] - arr[0];
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(canPlace(arr, mid, k)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {0,3,4,7,10,9};
        int cows = 4;
        AggressiveCows obj = new AggressiveCows();
        int result = obj.aggressiveCowss(arr, cows);
        System.out.println("The aggresive cows are: "+result);
        
    }
}
