public class SearchSingleEle {

    // brute force
    /*
     * time complexity: O(N),we are traversing the entire array.Where N is the size
     * of the array
     * space complexity: O(1) as we are not using any extra space
     */
    // public int searchEle(int arr[]){
    //     int size = arr.length;
    //     if(size == 1){
    //         return arr[0];
    //     }
    //     for(int i=0; i<size; i++){
    //         if(i == 0){
    //             if(arr[i] != arr[i+1]){
    //                 return arr[i];
    //             }
    //         }
    //         else if(arr[i] != arr[i-1]){
    //             return arr[i];
    //         }
    //         else{
    //             if(arr[i] != arr[i+1] && arr[i] != arr[i-1]){
    //                 return arr[i];
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach
    /*
     * time complexity: O(log2 N),where n is the size of the array,as we are using
     * binary search
     * space complexity: O(1),as we are not using any extra space
     */
    
    // public int searchEle(int arr[]){
    //     int n = arr.length;
    //     if(n == 1) return arr[0];
    //     if(arr[0] != arr[1]) return arr[0];
    //     if(arr[n-1] != arr[n-2]) return arr[n-1];
    //     int low = 1;
    //     int high = n-2;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
    //             return arr[mid];
    //         }
    //         if((mid % 2 == 0 && arr[mid] != arr[mid+1]) ||
    //         (mid % 2 == 1 && arr[mid] != arr[mid-1])){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return -1;
    // }

    // public int searchEle(int arr[]){
    //     int n = arr.length;
    //     if(n == 1) return arr[0];
    //     if(arr[0] != arr[1]) return arr[0];
    //     if(arr[n-1] != arr[n-2]) return arr[n-1];
    //     int low = 1;
    //     int high = n-2;
    //     while(low < high){
    //         int mid = (low+high)/2;
    //         if(mid % 2 == 1){
    //             mid--;
    //         }
    //         if(arr[mid] == arr[mid+1]){
    //             low = mid+2;
    //         }
    //         else{
    //             high = mid;
    //         }
    //     }
    //     return arr[low];
    // }

    public int searchEle(int arr[]){
        int n = arr.length;
        if(n == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }
            if((mid % 2 == 0 && arr[mid] != arr[mid+1]) ||
            (mid % 2 == 1 && arr[mid] != arr[mid-1])){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int arr[] = { 1, 1, 1, 2, 3, 3, 4, 4, 5, 5 };
        // SearchSingleEle obj = new SearchSingleEle();
        // int result = obj.searchEle(arr);
        // System.out.println("The single element is: " + result);

        int arr[] = {1,1,2,2,3,4,4,5,5};
        SearchSingleEle obj = new SearchSingleEle();
        int result = obj.searchEle(arr);
        System.out.println("The single element is: "+result);
    }
}
