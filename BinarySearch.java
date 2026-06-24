public class BinarySearch {

    // iterative approach

    // static  int binarySearchs(int arr[],int x){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = low+(high-low)/2;
    //         if(arr[mid] == x){
    //             return mid;
    //         }
    //         if(arr[mid] < x){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return -1;
    // }


    // Iterative approach
    /*
     * Time Complexity: In the algorithm, in every step, we are basically dividing
     * the search space into 2 equal halves. This is actually equivalent to dividing
     * the size of the array by 2, every time. After a certain number of divisions,
     * the size will reduce to such an extent that we will not be able to divide
     * that anymore and the process will stop. The number of total divisions will be
     * equal to the time complexity. So the overall time complexity is O(logN),
     * where N = size of the given array.
     * 
     * Space Complexity: 0(1), no extra space being used
     */

    // static int binarySearchs(int arr[],int n,int target){
    //     int low = 0;
    //     int high = n-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             return mid;
    //         }
    //         else if(target > arr[mid]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return -1;
    // }

    // recursive approach

    /*
     * Time Complexity: In the algorithm, in every step, we are basically dividing
     * the search space into 2 equal halves. This is actually equivalent to dividing
     * the size of the array by 2, every time. After a certain number of divisions,
     * the size will reduce to such an extent that we will not be able to divide
     * that anymore and the process will stop. The number of total divisions will be
     * equal to the time complexity. So the overall time complexity is O(logN),
     * where N = size of the given array.
     * 
     * Space Complexity: 0(1), no extra space being used
     */
    public static int binaryS(int arr[],int low,int high,int target){
        if(low > high) return -1;
        int mid = (low+high)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(target > arr[mid]){
            return binaryS(arr, mid+1, high, target);
        }
        else{
            return binaryS(arr, low, mid-1, target);
        }
    }

    public static int search(int arr[],int target){
        return binaryS(arr, 0, arr.length-1, target);
    }
    public static void main(String[] args) {
        // int arr[] = {2,3,4,10,40};
        // int x = 10;
        // int result = binarySearchs(arr, x);
        // if(result == -1){
        //     System.out.println("Element is not present in the array!");
        // }
        // else{
        //     System.out.println("Element is present at "+"index: "+result);
        // }

        // int arr[] = {2,4,8,6,9,10,12};
        // int target = 6;
        // int n = arr.length;
        // // int result = binarySearchs(arr, 7,6);
        // int result = binarySearchs(arr, n, target);
        // if(result == -1){
        //     System.out.println("Element is not present in the array: ");
        // }
        // else{
        //     System.out.println("The element is present at "+"index: "+result);
        // }

        int arr[] = {2,3,5,6,9,8};
        int target = 9;
        int indx = search(arr, target);
        if(indx == -1){
            System.out.println("The element do not present in the array: ");
        }
        else{
            System.out.println("The element is present at "+"index: "+indx);
        }
    }
}
