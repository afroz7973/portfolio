public class UpperBound {

    // brute force
    /*
     * time complexity: O(N),where n is the size of array
     * space complexity:O(1), since no extra space is used
     */
    // public static int upperBoundFinder(int arr[],int target){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] > target){
    //             return i;
    //         }
    //     }
    //     return arr.length;
    // }

    // optimal approach
    /*
     * time complexity: O(log N), which is typical used for binary search
     * sppace complexity: O(1),since no extra space is used
     */
    // public static int lowerBoundFinder(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     int ans = arr.length;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] > target){
    //             ans = mid;
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;
    // }

    public static int upperBoundFinder(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low+high/2);
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int arr[] = {2,4,5,6,7,9};
        // int target = 8;
        // UpperBound obj = new UpperBound();
        // int result = obj.upperBoundFinder(arr, target);
        // System.out.println("The element is present at index: "+result);

        // int arr[] = {2,4,5,7,8,9};
        // int target = 6;
        // UpperBound obj = new UpperBound();
        // int result = obj.lowerBoundFinder(arr, target);
        // System.out.println("The element is present at index: "+result);

        int arr[] = {2,4,7,8,9};
        int target = 6;
        UpperBound obj = new UpperBound();
        int ind = obj.upperBoundFinder(arr, target);
        System.out.println("The element is present at index: "+ind);
    }
}
