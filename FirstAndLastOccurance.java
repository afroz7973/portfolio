
import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurance {
    // brute force
    /*
     * time complexity:O(N), where N is the size of the array.This is because we are
     * traversing the array once to find the last occurance of the target element
     * space complexity:O(1), as we are using constant amount of space for the
     * result variable and the loop index, we are not using any extra data structure
     * that grow with the input sice
     * 
     */
    // public int findingOccurance(List<Integer> arr,int key,int n){
    // int result = -1;
    // for(int i=n-1; i >= 0; i--){
    // if(arr.get(i) == key){
    // result = i;
    // break;
    // }
    // }
    // return result;
    // }

    // better approach
    /*
     * time complexity: 2*O(lon2N), since we are using lower bound and upper bound
     * space complexity: O(1)
     */
    // public static int findFirst(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     int ans = arr.length;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] >= target){
    //             ans = mid;
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;
    // }

    // public static int findLast(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     int ans = arr.length;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             ans = mid;
    //             low = mid+1;
    //         }
    //         else if (arr[mid] < target){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // public int[] getFirstAndLast(int arr[],int  target){
    //     int first = findFirst(arr, target);
    //     int last = findLast(arr, target);
    //     return new int[]{first,last};
    // }

    // public int[] findingOccurance(List<Integer> arr, int key) {
    //     int first = -1;
    //     int last = -1;
    //     for (int i = 0; i < arr.size(); i++) {
    //         if (arr.get(i) == key) {
    //             if (first == -1) {
    //                 first = i;
    //             }
    //             last = i;
    //         }
    //     }
    //     return new int[] { first, last };
    // }

    /*
     * time complexity: 2*O(log2 N) 
     */
    // public static int findFirst(int arr[],int n,int target){
    //     int low = 0;
    //     int high = n-1;
    //     int first = -1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] >= target){
    //             first = mid;
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return first;
    // }

    // public static int findLast(int arr[],int n,int target){
    //     int low = 0;
    //     int high = n-1;
    //     int last = -1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             last = mid;
    //             low = mid+1;
    //         }
    //         else if(arr[mid] < target){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return last;
    // }

    // public int[] getFirstAndLast(int arr[],int n,int target){
    //     int first = findFirst(arr, n, target);
    //     int last = findLast(arr, n, target);
    //     return new int[]{first,last};
    // }

    // optimal approach
    /*
     * time complexity: O(logN) where N is the size of the array. This is because we
     * are using binary search, which reduces the search space by half in each
     * iteration.
     * 
     * Space Complexity: O(1), as we are using a constant amount of space for the
     * result variable and the loop indices. We are not using any additional data
     * structures that grow with the input size.
     */
    public int occuranceFind(List<Integer> arr,int n,int key){
        int low = 0;
        int high = n-1;
        int res = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr.get(mid) == key){
                res = mid;
                low = mid+1;
            }
            else if(key < arr.get(mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // List<Integer> arr = Arrays.asList(3,4,13,13,13,20,40);
        // int key = 13;
        // int n = 7;
        // FirstAndLastOccurance obj = new FirstAndLastOccurance();
        // int ans = obj.findingOccurance(arr, key, n);
        // System.out.println(ans);

        // List<Integer> arr = Arrays.asList(3, 4, 13, 13, 13, 20, 40);
        // int key = 13;
        // FirstAndLastOccurance obj = new FirstAndLastOccurance();
        // int result[] = obj.findingOccurance(arr, key);
        // System.out.println("The first and last occurance of element is: " + result[0] + " " + result[1]);
        // int arr[] = {3,4,13,13,13,20,40};
        // int target = 13;
        // FirstAndLastOccurance obj = new FirstAndLastOccurance();
        // int result[] = obj.getFirstAndLast(arr, target);
        // System.out.println("The fist and last occurance of element is: "+result[0]+" "+result[1]);

        // int arr[] = {3,4,13,13,13,20,40};
        // int n = 7;
        // int target = 13;
        // FirstAndLastOccurance obj = new FirstAndLastOccurance();
        // int result[] = obj.getFirstAndLast(arr, n, target);
        // System.out.println("The first and last occurance is: "+result[0]+" "+result[1]);

        List<Integer> arr = Arrays.asList(3,4,13,13,13,20,40);
        int n = arr.size();
        int key = 13;
        FirstAndLastOccurance obj = new FirstAndLastOccurance();
        int ans = obj.occuranceFind(arr, n, key);
        System.out.println("The last occurance of the "+ key +" is: "+ans);
    }
}