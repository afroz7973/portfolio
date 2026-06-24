import java.util.Arrays;

public class PainterPartitions {
    // brute force
    /*
     * time complexity: O(N*(sum(arr[])-max(arr[])+1)), N is the size of the
     * array.sum(arr[]) is the sum of all array element and max(arr[]) is the
     * maximum of all array element.
     * spacce complexity: O(1) since we are not using any extra space to solve this problem
     */
    // public int countPainters(int arr[],int time){
    //     int n = arr.length;
    //     int painters = 1;
    //     int boardTime = 0;
    //     for(int i=0; i<n; i++){
    //         if(boardTime + arr[i] <= time){
    //             boardTime += arr[i];
    //         }
    //         else{
    //             painters++;
    //             boardTime = arr[i];
    //         }
    //     }
    //     return painters;
    // }

    // public int largetsMinimizedDistance(int arr[],int k){
    //     int low = Arrays.stream(arr).max().getAsInt();
    //     int high = Arrays.stream(arr).sum();
    //     for(int time=low; time<=high; time++){
    //         if(countPainters(arr, time) <= k){
    //             return time;
    //         }
    //     }
    //     return low;
    // }

    // optimal approach

    /*
     * time complexity: O(N*log(sum(arr[])+max(arr[])+1)),where N is the size of the
     * array.sum(arr[]) is the sum of all array element and max(arr[]) maximum of
     * all array element.
     * space complexity: O(1) as we are not using any extra space to solve this problem.
     */
    // public int countPainters(int arr[],int time){
    //     int n = arr.length;
    //     int painters = 1;
    //     int boardTime = 0;
    //     for(int i=0; i<n; i++){
    //         if(boardTime + arr[i] <= time){
    //             boardTime += arr[i];
    //         }
    //         else{
    //             painters++;
    //             boardTime = arr[i];
    //         }
    //     }
    //     return painters;
    // }

    // public int largetsMinimizedDistance(int arr[],int k){
    //     int low = Arrays.stream(arr).max().getAsInt();
    //     int high = Arrays.stream(arr).sum();
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         int painters = countPainters(arr, mid);
    //         if(painters > k){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return low;
    // }

    // brute force

    /*
     * time complexity: O(N*(sum(arr[])-max(arr[])+1)) where N is the size of the
     * array.sum(arr[]) is the sum of all array element and max(arr[]) is the
     * maximum of all array element.
     * space complexity: O(1), since we are not using any extra space to solve this problem
     */
    // public int countPainters(int arr[],int time){
    //     int n = arr.length;
    //     int painters = 1;
    //     int boardTime = 0;
    //     for(int i=0; i<n; i++){
    //         if(boardTime + arr[i] <= time){
    //             boardTime += arr[i];
    //         }
    //         else{
    //             painters++;
    //             boardTime = arr[i];
    //         }
    //     }
    //     return painters;
    // }

    // public int minLargestDistance(int arr[],int k){
    //     int low = Arrays.stream(arr).max().getAsInt();
    //     int high = Arrays.stream(arr).sum();
    //     for(int time=low; time<=high; time++){
    //         if(countPainters(arr, time) <= k){
    //             return time;
    //         }
    //     }
    //     return low;
    // }

    // optimal approach

    public int countPainters(int boards[],int time){
        int painters = 1;
        int boardTime = 0;
        for(int board : boards){
            if(boardTime + board <= time){
                boardTime += board;
            }
            else{
                painters++;
                boardTime = board;
            }
        }
        return painters;
    }

    public int minLargestDistance(int boards[],int k){
        int low = Arrays.stream(boards).max().getAsInt();
        int high = Arrays.stream(boards).sum();
        while(low <= high){
            int mid = (low+high)/2;
            int painters = countPainters(boards, mid);
            if(painters > k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {5,5,5,5};
        int k = 2;
        PainterPartitions obj = new PainterPartitions();
        int result = obj.minLargestDistance(arr, k);
        System.out.println("The answer is: "+result);
    }
}
