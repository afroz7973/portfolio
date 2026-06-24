public class BinarySearchs {
    // iterative approach
    /*
    time complexity: 
     */
    // public static int binaryS(int arr[],int target){
    // int n = arr.length;
    // int low = 0;
    // int high = n-1;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] == target){
    // return mid;
    // }
    // else if(target > arr[mid]){
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // return -1;
    // }

    // recursive approach

    // public static int binaryS(int arr[], int low, int high, int target) {
    //     if (low > high)
    //         return -1;
    //     int mid = (low + high) / 2;
    //     if (arr[mid] == target) {
    //         return mid;
    //     } else if (target > arr[mid]) {
    //         return binaryS(arr, mid + 1, high, target);
    //     } else {
    //         return binaryS(arr, low, mid - 1, target);
    //     }
    // }

    // public static int search(int arr[], int target) {
    //     return binaryS(arr, 0, arr.length - 1, target);
    // }


    // public static int binaryS(int arr[],int low,int high,int target){
    //     if(low > high) return -1;
    //     int mid = (low+high)/2;
    //     if(arr[mid] == target){
    //         return mid;
    //     }
    //     else if(target > arr[mid]){
    //         return binaryS(arr, low+1, high, target);
    //     }
    //     else{
    //         return binaryS(arr, low, low-1, target);
    //     }
    // }

    // public static int search(int arr[],int target){
    //     return binaryS(arr, 0, arr.length-1, target);
    // }

    // iterative approach
    // public static int binaryS(int arr[],int n,int target){
    //     int low = 0;
    //     int high = n-1;
    //     while(low < high){
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
     * time complexity: O(logN), where N is the size of the array
     * space complexity: O(1), SINCE NO EXTRA SPACE IS BEING USED
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
        // int arr[] = {2,3,5,7,9,10};
        // int target = 9;
        // int result = binaryS(arr, target);
        // if(result == -1){
        // System.out.println("The element is not present in the array: ");
        // }
        // else{
        // System.out.println("The element is present at "+"index: "+result);
        // }

        // int arr[] = {2,4,6,7,8,9};
        // int target = 9;
        // // int n = arr.length;
        // int result = search(arr, target);
        // if(result == -1){
        //     System.out.println("The element is not present in the array: ");
        // }
        // else{
        //     System.out.println("The element is present at "+"index: "+result);
        // }

        // int arr[] = {2,5,6,7,8,9};
        // int target = 6;
        // int result = search(arr, target);
        // if(result == -1){
        //     System.out.println("The element is not present int the array: ");
        // }
        // else{
        //     System.out.println("The element is present at "+"index: "+result);
        // }

        // int arr[] = {2,3,5,6,8,9};
        // int n = arr.length;
        // int target = 8;
        // int result = binaryS(arr, n, target);
        // if(result == -1){
        //     System.out.println("The element is not present in the array: ");
        // }
        // else{
        //     System.out.println("The element is present at "+"index: "+result);
        // }

        int arr[] = {2,6,7,8,9};
        int target = 7;
        int indx = search(arr, target);
        if(indx == -1){
            System.out.println("The elemetn is not present:");
        }
        else{
            System.out.println("The element is present at "+"index: "+indx);
        }
    }
}
