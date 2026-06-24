public class Bubble {
    public static void sortBubble(int[] arr, int n){
        // Time Complexity: O(N2) for the worst and average cases and O(N) for the best
        // case. Here, N = size of the array.

        for(int i=n-1; i>=0; i--){
            int didSwap = 0;
            for(int j=0; j<=i-1; j++){
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
        }
        System.out.print("After bubble sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,8,4,6,2};
        int n = arr.length;
        System.out.print("Before bubble sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sortBubble(arr, n);
    }
}
