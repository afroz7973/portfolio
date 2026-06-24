public class FloorCeilFinder {
    // optimal approach
    /*
     * time complexity: O(log N), where N is the size of the array.It is because we
     * are using binary search
     * space complexity: O(1), since we are not using any extra space
     */
    // public static int findFloor(int arr[],int target){
    // int low = 0;
    // int high = arr.length-1;
    // int ans = -1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] <= target){
    // ans = arr[mid];
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // return ans;
    // }

    // public static int findCeil(int arr[],int target){
    // int low = 0;
    // int high = arr.length-1;
    // int ans = -1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] >= target){
    // ans = arr[mid];
    // high = mid-1;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // return ans;
    // }

    // public int[] getFloorAndCeil(int arr[],int target){
    // int floor = findFloor(arr, target);
    // int ceil = findCeil(arr, target);
    // return new int[]{floor,ceil};
    // }

    public static int findFloor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findCeil(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] getFloorAndCeil(int arr[], int target) {
        int floor = findFloor(arr, target);
        int ceil = findCeil(arr, target);
        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 4, 4, 7, 8, 10};
        // int target = 5;
        // FloorCeilFinder obj = new FloorCeilFinder();
        // int result[] = obj.getFloorAndCeil(arr, target);
        // System.out.println("The floor and ceil are: "+result[0]+" "+result[1]);

        int arr[] = { 3, 4, 5, 7, 8, 9 };
        int target = 6;
        FloorCeilFinder obj = new FloorCeilFinder();
        int result[] = obj.getFloorAndCeil(arr, target);
        System.out.println("The element is present at index: " + result[0] + " " + result[1]);

    }
}
