public class LowerBound {
    // optimal approach
    /*
     * time complexity: O(logN), used for typical binary search
     * space complexity: O(1)
     */
    // public static int boundLower(int arr[],int n,int target){
    //     int low = 0;
    //     int high = n-1;
    //     int ans = n;
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

    // brute force
    /*
     * time complexity: O(n) where n is the size of array
     * space complexity: O(1), since no extra space is used
     */
    // public static int lowerBoundFinder(int arr[],int target){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] >= target){
    //             return i;
    //         }
    //     }
    //     return arr.length;
    // }

    // optimal approach

    // public static int lowerBoundFinder(int arr[],int x){
    //     int low = 0;
    //     int high = arr.length-1;
    //     int ans = arr.length;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] >= x){
    //             ans = mid;
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;
    // }

    // brute force

    // public int lowerBoundFinder(int arr[],int  target){
    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] >= target){
    //             return i;
    //         }
    //     }
    //     return arr.length;
    // }

    // optimal approach
    /*
     * time complexity: O(logN), where n is the size of the array
     * space complexity:O(1), since no extra space is used
     */


     public static int lowerBoundFinder(int arr[],int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= target){
                return i;
            }
        }
        return arr.length;
     }
     
        public static void main(String[] args) {
        // int arr[] = {2,5,7,8,9};
        // int n = arr.length;
        // int target = 6;
        // int result = boundLower(arr, n, target);
        // if(result == -1){
        //     System.out.println("The element is not present: ");
        // }
        // else{
        //     System.out.println("The element is present is at "+"index: "+result);
        // }

        // int arr[] = {2,4,6,7,8,9};
        // int target = 5;
        // int result = lowerBoundFinder(arr, target);
        // if(result == -1){
        //     System.out.println("The element is present in the array: ");
        // }
        // else{
        //     System.out.println("The element is present at "+"index: "+result);
        // }

        // int arr[] = {2,5,6,8,9,10};
        // int x = 7;
        // LowerBound finder = new LowerBound();
        // int ind = finder.lowerBoundFinder(arr, x);
        // System.out.println("The element present at index: "+ind);

        // int arr[] = {2,5,6,8,9};
        // int x = 7;
        // LowerBound obj = new LowerBound();
        // int result = obj.lowerBoundFinder(arr, x);
        // System.out.println("The element present at index: "+result);

        // int arr[] = {2,4,5,7,8,9};
        // int target = 6;
        // LowerBound obj = new LowerBound();
        // int result = obj.lowerBoundFinder(arr, target);
        // System.out.println("The element is present at index: "+result);

        int arr[] = {2,5,7,8,9};
        int target = 6;
        LowerBound obj = new LowerBound();
        int result = obj.lowerBoundFinder(arr, target);
        System.out.println("The element is present at index: "+result);
    }
}
