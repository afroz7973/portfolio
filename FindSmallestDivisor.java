import java.util.Arrays;
public class FindSmallestDivisor {
    // brute force
    /*
     * time complexity: O(max(arr[])*N),where max(arr[]) = maximum size of the
     * array,N=size of the array.We are using nested loop .The outer loop run from 1
     * to max(arr[] and the inner loop runs for N times)
     * space complexity: O(1),as we are not using any extra space to solve this problem
     */
    // public int smallestDivisor(int arr[],int limit){
    //     int n = arr.length;
    //     int max = Integer.MIN_VALUE;
    //     for(int num : arr){
    //         max = Math.max(max, num);
    //     }
    //     for(int d=1; d<=max; d++){
    //         int sum = 0;
    //         for(int i=0; i<n; i++){
    //             sum += (int) Math.ceil((double) arr[i]/d);

    //         }
    //         if(sum <= limit){
    //             return d;
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach

    /*
     * time complexity: O(log(max(arr[]))*N,where max(arr[])=maximum size of the
     * array,N=size of the array.We are applying binary search on our answer that
     * are int the range of of[1,max(arr[])].For every possible divisor 'mid',we
     * call the sumByD() function.Inside that function,we are traversing the entire
     * array,which result in O(N))
     * space complexity: O(1),as we are not using any extra space to solve this problem
     */
    // public int sumByDivisor(int arr[],int divisor){
    //     int sum = 0;
    //     for(int num : arr){
    //         sum += Math.ceil((double) num/divisor);
    //     }
    //     return sum;
    // }
    // public int smallestDivisor(int arr[],int limit){
    //     if(arr.length > limit){
    //         return -1;
    //     }
    //     int low = 1;
    //     int high = Arrays.stream(arr).max().getAsInt();
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(sumByDivisor(arr, mid) <= limit){
    //             high = mid-1;
    //         }
    //         else{
    //             low = mid+1;
    //         }
    //     }
    //     return low;
    // }

    // brute force

    /*
     * time complexity: O(max(arr[])*N),where max(arr[]) = maximum size of the
     * array,N=size of the array.We are using nested loops.The outer loop runs from
     * 1 to max(arr[]) and the inner loop runs for N times.
     * space complexityO(1),since we are not using any extra space to solve this problem
     */
    // public int smallestDivisor(int arr[],int limit){
    //     int n = arr.length;
    //     int max = Integer.MIN_VALUE;
    //     for(int num : arr){
    //         max = Math.max(max, num);
    //     }
    //     for(int d=1; d<=max; d++){
    //         int sum = 0;
    //         for(int i=0; i<n; i++){
    //             sum += Math.ceil((double) arr[i]/d);
    //         }
    //         if(sum <= limit){
    //             return d;
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach

    /*
     * time complexity: O(log(max(arr[]))*N),where max(arr[]) = maximum size of the
     * array,N=size of the array.we are applying binary search on our answer that
     * are in the range of [1,max(arr[])].For every possible divisor 'mid',we call
     * the sumByDivisor() function.Inside that function, we are traversing the
     * entire array, which results in O(N)
     * space complexity: O(1),no extra space is used to slove this problem..
     */
    public int sumByDivisor(int arr[],int divisor){
        int sum = 0;
        for(int nums : arr){
            sum += Math.ceil((double) nums/divisor);
        }
        return sum;
    }
    public int smallestDivisor(int arr[],int limit){
        if(arr.length > limit){
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        while(low <= high){
            int mid = (low+high)/2;
            if(sumByDivisor(arr, mid) <= limit){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int div = 8;
        FindSmallestDivisor obj = new FindSmallestDivisor();
        int result = obj.smallestDivisor(arr, div);
        System.out.println("The minimum divisor is: "+result);
    }
}
