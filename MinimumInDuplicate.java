public class MinimumInDuplicate {
    /*
     * time complexity: O(log N) for best and average case.O(N) for the worst case
     * space complexity: O(1), Since we are not using any extra space
     */
    // public int minimumInDup(int arr[]){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low < high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] < arr[high]){
    //             high = mid;
    //         }
    //         else if(arr[mid] > arr[high]){
    //             low = mid+1;
    //         }
    //         else{
    //             high--;
    //         }
    //     }
    //     return arr[low];
    // }

    public int minimumInDup(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < arr[high]){
                high = mid;
            }
            else if(arr[mid] > arr[high]){
                low = mid+1;
            }
            else{
                high--;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {
        // int arr[] = {4,5,6,1,2,2,2,3};
        // MinimumInDuplicate obj = new MinimumInDuplicate();
        // int result = obj.minimumInDup(arr);
        // System.out.println("The minimum element in duplicate: "+result);

        int arr[] = { 2, 2, 2, 0, 1, 2 };
        MinimumInDuplicate obj = new MinimumInDuplicate();
        int result = obj.minimumInDup(arr);
        System.out.println("The minimum element in duplicate is: "+result);
    }
}
