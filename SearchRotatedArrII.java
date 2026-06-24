public class SearchRotatedArrII {
    // optimal approach
    /*
     * Time complexity: O(log2 N) for the best and average case. O(N/2) for the
     * worst case.Where N is the size of array
     * space complexity: O(1), no extra space is used
     */
    // public boolean eleRotatedArr(int arr[],int target){
    // int low = 0;
    // int high = arr.length-1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] == target){
    // return true;
    // }
    // if(arr[low] == arr[mid] && arr[mid] == arr[high]){
    // low++;
    // high--;
    // continue;
    // }
    // if(arr[low] <= arr[mid]){
    // if(arr[low] <= target && target <= arr[mid]){
    // high = mid-1;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // else{
    // if(arr[mid] <= target && target <= arr[high]){
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // }
    // return false;
    // }

    // brute force
    /*
     * Time complexity: O(N), where n is the size of array
     * space complexity: O(1) No extra space is used
     */
    // public boolean rotatedEleArr(int arr[],int target){
    // for(int num:arr){
    // if(num == target){
    // return true;
    // }
    // }return false;
    // }
    /*
     * time complexity:O(log2N), for the best and average case.O(N/2) for the worst
     * case
     * space complexity:O(1), since no extra space is used
     */
    // public boolean rotatedEleArr(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target) return true;
    //         if(arr[low] == arr[mid] && arr[mid] == arr[high]){
    //             low++;
    //             high--;
    //             continue;
    //         }
    //         if(arr[low] <= arr[mid]){
    //             if(arr[low] <= target && target <= arr[high]){
    //                 high = mid-1;
    //             }
    //             else{
    //                 low = mid+1;
    //             }
    //         }
    //         else{
    //             if(arr[mid] <= target && target <= arr[high]){
    //                 low = mid+1;
    //             }
    //             else{
    //                 high = mid-1;
    //             }
    //         }
    //     }
    //     return false;
    // }

    /*
     * time complexity:O(log2N), for the best and average case.O(N/2) FOR THE WORST
     * CASE
     * space complexity: O(1),Since no extra space is used
     */
    public boolean rotatedEle(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int arr[] = {7,8,1,2,3,3,3,3,4,5,6};
        // int target = 3;
        // SearchRotatedArrII obj = new SearchRotatedArrII();
        // boolean result = obj.eleRotatedArr(arr, target);
        // System.out.println("The rotated element is: "+result);

        // int arr[] = {7,8,1,2,3,3,3,3,4,5,6};
        // int target = 3;
        // SearchRotatedArrII obj = new SearchRotatedArrII();
        // boolean result = obj.rotatedEleArr(arr, target);
        // System.out.println("The rotated element is: "+result);

        // int arr[] = {7,8,9,1,2,3,3,3,3,4,5};
        // int target = 3;
        // SearchRotatedArrII obj = new SearchRotatedArrII();
        // boolean result = obj.rotatedEleArr(arr, target);
        // if(!result){
        //     System.out.println("The element is not present in the array: ");
        // }
        // else{
        // System.out.println("The rotated element is: "+result);
        // }

        // int arr[] = {5,6,7,1,2,3,3,3,4};
        // int target = 30;
        // SearchRotatedArrII obj = new SearchRotatedArrII();
        // boolean result = obj.eleRotatedArr(arr, target);
        // if(!result){
        //     System.out.println("The element is not present in the array:");
        // }
        // else{
        //     System.out.println("The rotated element is: "+result);
        // }
        // System.out.println("The rotated element is: "+result);

        int arr[] = {5,6,7,1,2,3,3,3,4};
        int target = 3;
        SearchRotatedArrII obj = new SearchRotatedArrII();
        boolean result = obj.rotatedEle(arr, target);
        System.out.println("The rotated element is: "+result);
    }
}
