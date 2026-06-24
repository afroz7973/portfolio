public class CountOccurenceOfArr {
    // brute force
    /*
     * time complexity: O(N) We are traversing the whole array
     * space complexity: O(1) As we are not using any extra space
     */
    
    //  public static int countOccurance(int arr[],int x){
    //     int n = arr.length;
    //     int cnt = 0;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] == x){
    //             cnt++;
    //         }
    //     }
    //     return cnt;
    //  }

    //optimal approach
    /*
     * time complexity: O(2*log N), since we are using binary search twice
     * space complexity: O(1), Since we are not using any extra space
     */
    public static int firstOccurnace(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int first = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return first;
    }

    public static int lastOccurance(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int last = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return last;
    }

    public static int[] getFirstAnsLast(int arr[],int target){
        int first = firstOccurnace(arr, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = lastOccurance(arr, target);
        return new int[]{first,last};
    }

    public static int count(int arr[],int target){
        int ans[] = getFirstAnsLast(arr, target);
        if(ans[0] == -1){
            return 0;
        }
        return (ans[1] - ans[0]+1);
    }
    public static void main(String[] args) {
        // int arr[] = {2,3,8,8,8,8,9};
        // int x = 8;
        // int result = countOccurance(arr, x);
        // System.out.println("The occurance of "+ x +" is: "+result);

        int arr[] = {2,5,6,6,6,8,9};
        int x = 6;
        int result = count(arr, x);
        System.out.println("The occurance of "+ x +" is: "+result);
    }
}
