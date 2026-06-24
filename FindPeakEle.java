public class FindPeakEle {
    // brute force
    // Time complexity: O(N) we traverse the entire array to find the peak element
    // space complexity: O(1),constant aditional space is used
    // public int findPeak(int arr[]){
    // int n = arr.length;
    // for(int i=0; i<n; i++){
    // boolean left = (i == 0) || (arr[i] >= arr[i-1]);
    // boolean right = (i == n-1) || (arr[i] >= arr[i+1]);

    // if(left && right) return i;
    // }
    // return -1;
    // }

    // optimal approach
    /*
     * Time complexity: O(log2 N),we reduce the search space to half at every step
     * using Binary search
     * space complexity: O(1), constantant additional space is used
     */
    // public int peakEle(int arr[]){
    // int low = 0;
    // int high = arr.length-1;
    // while(low < high){
    // int mid = (low+high)/2;
    // if(arr[mid] > arr[mid+1]){
    // high = mid;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // return low;
    // }

    // another optimal
    // public int peakElement(int arr[]){
    // int n = arr.length;
    // if(n == 1) return 0;
    // if(arr[0] > arr[1]) return 0;
    // if(arr[n-1] > arr[n-2]) return n-1;
    // int low = 1;
    // int high = n-2;
    // while(low <= high){
    // int mid = (low+high)/2;
    // if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
    // return mid;
    // }
    // else if(arr[mid] > arr[mid-1]){
    // low = mid+1;
    // }
    // else{
    // high = mid-1;
    // }
    // }
    // return -1;
    // }

    // public int peakElement(int arr[]){
    // int low = 0;
    // int high = arr.length-1;
    // while(low < high){
    // int mid = (low+high)/2;
    // if(arr[mid] > arr[mid+1]){
    // high = mid;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // return low;
    // }

    // public int findPeak(int arr[]){
    // int low = 0;
    // int high = arr.length-1;
    // while(low < high){
    // int mid = (low+high)/2;
    // if(arr[mid] > arr[mid+1]){
    // high = mid;
    // }
    // else{
    // low = mid+1;
    // }
    // }
    // return low;
    // }

    // public int findPeak(int arr[]) {
    //     int low = 0;
    //     int high = arr.length - 1;
    //     while (low < high) {
    //         int mid = (low + high) / 2;
    //         if(arr[mid] > arr[mid+1]){
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return low;
    // }

    // public int findPeak(int arr[]){
    //     int n = arr.length;
    //     if(n == 1) return 0;
    //     if(arr[0] > arr[1]) return 0;
    //     if(arr[n-1] > arr[n-2]) return n-1;
    //     int low = 1;
    //     int high = n-2;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
    //             return mid;
    //         }
    //         if(arr[mid] > arr[mid-1]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return -1;
    // }

    /*
     * time complexity: O(log2 N), we reduce the search space to half at every step
     * using binary search
     * space complexity: O(1), since no additional space is used
     */
    // public int findPeak(int arr[]){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low < high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] > arr[mid+1]){
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return low;
    // }

    public int findPeak(int arr[]){
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        int low = 1;
        int high = n-2;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }
            if(arr[mid] > arr[mid-1]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 4, 3 };
        FindPeakEle obj = new FindPeakEle();
        int result = obj.findPeak(arr);
        System.out.println("The peak element is: " + arr[result]);
    }
}
