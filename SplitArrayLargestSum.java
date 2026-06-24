import java.util.Arrays;
public class SplitArrayLargestSum {
    // brute force
    /*
     * time complexity:O(N*max(arr[])-sum(arr[])+1),where N is the size of the
     * array,max(arr[]) is the maximum of all array element and sum(arr[]) is the
     * sum of all array element
     * space complexity:O(1),since we are not using any extra space to solve this problem
     */

    // public int countPartitions(int arr[],int maxSum){
    //     int n = arr.length;
    //     int partitions = 1;
    //     int subArraySum = 0;
    //     for(int i=0; i<n; i++){
    //         if(subArraySum + arr[i] <= maxSum){
    //             subArraySum += arr[i];
    //         }
    //         else{
    //             partitions++;
    //             subArraySum = arr[i];
    //         }
    //     }
    //     return partitions;
    // }

    // public int largetsMinimizedSum(int arr[],int k){
    //     int low = Arrays.stream(arr).max().getAsInt();
    //     int high = Arrays.stream(arr).sum();
    //     for(int maxSum=low; maxSum<=high; maxSum++){
    //         if(countPartitions(arr, maxSum) <= k){
    //             return maxSum;
    //         }
    //     }
    //     return low;
    // }

    // optimal approach
    /*
     * time complexity: O(N*log(sum(arr[])+max(arr[])+1)), where N is the size of
     * the array,sum(arr[]) is the sum of all array element and max(arr[]) is the
     * maximum of all array element.
     * space complexity: O(1),Since we are not using any extra space to solve this problem
     * 
     */
    public int countPartitions(int arr[],int maxSum){
        int n = arr.length;
        int partitions = 1;
        int subArraySum = 0;
        for(int i=0; i<n; i++){
            if(subArraySum + arr[i] <= maxSum){
                subArraySum += arr[i];
            }
            else{
                partitions++;
                subArraySum = arr[i];
            }
        }
        return partitions;
    }
    public int largestMinimizedSum(int arr[],int k){
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int mid = (low+high)/2;
            int partitions = countPartitions(arr, mid);
            if(partitions > k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 3;
        SplitArrayLargestSum obj = new SplitArrayLargestSum();
        int result = obj.largestMinimizedSum(arr, k);
        System.out.println("The largest subarray of minimized array is: "+result);
    }
}
