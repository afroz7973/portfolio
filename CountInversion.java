public class CountInversion {
    // Brute force
    /*
     * Time complexity: O(N^2) where N is the size of the array.This is bcz as every
     * pair is checked
     * space complexity O(1) since no extra space is used apart from variable
     */

    // static int countInversions(int arr[]){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[i] > arr[j]){
    //                 count += 1;
    //             }
    //         }
    //     }
    //     return count;
    // }
    

    // optimal approach
    /*
     * time complexity: O(N log N), since its based on merge sort
     * space complexity: O(N), for temporary array used during merging
     */

    // public int merge(int arr[],int low, int mid, int high){
    //     int temp[] = new int[high-low+1];
    //     int left = low;
    //     int right = mid+1;
    //     int k = 0;
    //     int count = 0;
    //     while(left <= mid && right <= high){
    //         if(arr[left] <= arr[right]){
    //             temp[k++] = arr[left++];
    //         }
    //         else{
    //             temp[k++] = arr[right++];
    //             count += (mid-left+1);
    //         }
    //     }
    //     while(left <= mid){
    //         temp[k++] = arr[left++];
    //     }
    //     while(right <= high){
    //         temp[k++] = arr[right++];
    //     }
    //     for(int i=low; i<=high; i++){
    //         arr[i] = temp[i-low];
    //     }
        
    //     return count;
    // }

    // public int mergeSort(int arr[],int low, int high){
    //     int count = 0;
    //     if(low >= high){
    //         return count;
    //     }
    //     int mid = (low+high)/2;
    //     count += mergeSort(arr, low, mid);
    //     count += mergeSort(arr, mid+1, high);
    //     count += merge(arr, low, mid, high);
    //     return count;
    // }
    // public int numberOfInversion(int arr[]){
    //     return mergeSort(arr, 0, arr.length-1);
    // }

    public int merge(int arr[],int low,int mid,int high){
        int temp[] = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k = 0;
        int cnt = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            }
            else{
                temp[k++] = arr[right++];
                cnt += mid-left+1;
            }
        }
        while(left <= mid){
            temp[k++] = arr[left++];
        }
        while(right <= high){
            temp[k++] = arr[right++];
        }
        return cnt;
    }

    public int mergeSort(int arr[],int low,int high){
        int cnt = 0;
        if(low >= high){
            return cnt;
        }
        int mid = (low+high)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public int inversionCount(int arr[]){
        return mergeSort(arr, 0, arr.length-1);
    }
    
    public static void main(String[] args) {
        // int arr[] = {5,4,3,2,1};
        // int ans = countInversions(arr);
        // System.out.println("The inversions count are: "+ans);

        // int arr[] = {5,4,3,2,1};
        // CountInversion obj = new CountInversion();
        // int count = obj.numberOfInversion(arr);
        // System.out.println("The number of inversion count are: "+count);

        int arr[] = {5,4,3,2,1};
        CountInversion obj = new CountInversion();
        int cnt = obj.inversionCount(arr);
        System.out.println("The number of inversion count are: "+cnt);

    }
}
