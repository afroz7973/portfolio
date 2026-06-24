
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int arr[],int n){
        // time complexity in the best case will boil down to O(N), where N = size of
        // the array.
        for(int i=0; i<=n-1; i++){
            int j = i;
            while(j>0 && arr[j-1] >arr[j]){
                // swap
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
                // System.out.println("Run");
             }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(arr, n);
        System.out.print("After after sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
