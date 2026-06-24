public class SearchEleRotatedArr {
    // brute force
    /*
     * Time complexity: O(N) We need to check every element in the worst case if the
     * target is not present
     * space complexity: O(1),Since no extra space is used,only constant variable is
     * used
     */
    // public int elementRotatedArr(int arr[],int n,int target){
    // for(int i=0; i<n; i++){
    // if(arr[i] == target){
    // return i;
    // }
    // }
    // return -1;
    // }

    // optimal approach
    /*
     * time complexity: O(log N) we eliminate half of the search space in each
     * iteration in Binary search
     * space complexity: O(1) We use a very few variable(low,mid,high) no extra
     * space is used
     */
    // public int searchRotatedEle(int arr[],int target){
    // int low = 0;
    // int high = arr.length-1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] == target){
    // return mid;
    // }
    // if(arr[low] <= arr[mid]){
    // if(arr[low] <= target && target < arr[mid]){
    // high = mid-1;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // else{
    // if(arr[mid] < target && target < arr[high]){
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // }
    // return -1;
    // }

    /*
     * time complexity: O(log N) we eliminate half of the search space in each
     * iteration using binary search
     * space complexity: O(1) WE USE only few variable (low,mid,high) no extra space
     * is used
     */
    // public int eleRotatedArr(int arr[],int target){
    // int low = 0;
    // int high = arr.length-1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] == target){
    // return mid;
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
    // if(arr[mid] < target && target < arr[high]){
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // }
    // return -1;
    // }

    /*
     * time complexity: O(N) we may need to check every element in the worst case if
     * the target is not present
     * space complexity: O(1) No extra space is used,only constant variable is used
     */
    // public static int eleRotatedArr(int arr[],int target){
    // for(int i=0; i<arr.length; i++){
    // if(arr[i] == target){
    // return i;
    // }
    // }
    // return -1;
    // }

    /*
     * time complexity: O(log N),we eliminate half of the search space in each
     * iteration using binary search
     * space complexity: O(1),we use only few variable (low,mid,high), no extra space isused
     */
    public int elementRotatedArr(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = {4,5,6,7,0,1,2,3};
        // int n = arr.length;
        // int target = 0;
        // SearchEleRotatedArr obj = new SearchEleRotatedArr();
        // int result = obj.elementRotatedArr(arr, n, target);
        // System.out.println("The rotated element is: "+result);

        // int arr[] = {4,5,6,7,1,2,3};
        // int target = 1;
        // SearchEleRotatedArr obj = new SearchEleRotatedArr();
        // int result = obj.searchRotatedEle(arr, target);
        // System.out.println("The rotated element is: "+result);

        // int arr[] = {4,5,6,7,0,1,2};
        // int target = 0;
        // SearchEleRotatedArr obj = new SearchEleRotatedArr();
        // int result = obj.eleRotatedArr(arr, target);
        // System.out.println("The rotated element is: "+result);

        // int arr[] = {4,5,6,0,1,2};
        // int target = 0;
        // SearchEleRotatedArr obj = new SearchEleRotatedArr();
        // int result = obj.eleRotatedArr(arr, target);
        // System.out.println("The rotated element is: "+result);

        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        SearchEleRotatedArr obj = new SearchEleRotatedArr();
        int result = obj.elementRotatedArr(arr, target);
        System.out.println("The rotated element is: " + result);
    }
}
