public class SearchInsertPos {
    // optimal approach

    /*
     * time complexity: O(log n) where n is the size of the array
     * space complexity: O(1) since no extra space is used
     */

    // public int insertPosition(int arr[],int target){
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

    public  int insertPosition(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] >= target){
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
        // int arr[] = {2,4,7,8,9};
        // int target = 5;
        // SearchInsertPos obj = new SearchInsertPos();
        // int ind = obj.insertPosition(arr, target);
        // System.out.println("The element is present at index: "+ind);

        int arr[] = {2,5,6,7,89};
        int target = 50;
        SearchInsertPos obj = new SearchInsertPos();
        int ind = obj.insertPosition(arr, target);
        System.out.println("The element is present at index: "+ind);
    }
}
