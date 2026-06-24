
import java.util.ArrayList;

public class ReversePairCnt {
    // brute force
    /*
     * Time complexity: O(N^2),since we are using nested loop which runs N times.
     * Space complexity: O(1),as we are not using any extra space to solve this problem.
     */
    // public int countReversePair(int arr[]){
    //     int n = arr.length;
    //     int count = 0;
    //     for(int i=0; i<n-1; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[i] > 2*arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // optimal approach

    /*
     * Time complexity: O(2*N logN) Inside the mergeSort() we call merge() and
     * countPairs() except mergeSort() itself. Now, inside the function
     * countPairs(), though we are running a nested loop, we are actually iterating
     * the left half once and the right half once in total. That is why, the time
     * complexity is O(N). And the merge() function also takes O(N). The mergeSort()
     * takes O(logN) time complexity. Therefore, the overall time complexity will be
     * O(logN * (N+N)) = O(2N*logN).
     * 
     * Space Complexity: O(N), as in the merge sort We use a temporary array to
     * store elements in sorted order.
     */

    public static void merge(int arr[],int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    public static int countPairs(int arr[],int low,int mid,int high){
        int right = mid+1;
        int count = 0;
        for(int i=low; i<=mid; i++){
            while(right <= high && arr[i]>2*arr[right]){
                right++;
            }
            count += (right-(mid+1));
        }
        return count;
    }

    public static int mergeSort(int arr[],int low,int high){
        int count = 0;
        if(low >= high ){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
    public static int team(int skill[],int n){
        return mergeSort(skill, 0, n-1);
    }


    
    public static void main(String[] args) {
        // int arr[] = {40,25,19,12,9,2};
        // ReversePairCnt obj = new ReversePairCnt();
        // int count = obj.countReversePair(arr);
        // System.out.println("The number of reverse count are: "+count);

        int a[] = {40,25,19,12,9,2};
        int n = a.length;
        int count = team(a, n);
        System.out.println("The number of reverse count pairs are: "+count);
    }
}
