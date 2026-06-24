
public class BubbleSort {
    public static void bubbleSort(int[] arr,int n){
        // Time complexity: O(N2), (where N = size of the array), for the worst, and
        // average cases.
        // for best case we need to use didswap
        for(int i=n-1; i>=0; i--){
            int didSwap = 0;
            for(int j=0; j<=i-1;j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0){
                break;
            }
            System.out.println("Run");
        }
        System.out.print("After bubble sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {25,4,66,9,8};
        int n = arr.length;
        System.out.print("Before selection sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        bubbleSort(arr, n);
    }
}
