
import java.util.Scanner;
public class SelectionSort {
    public static void sortSelection(int[] arr, int n){
        for(int i=0; i<=n-2; i++){
            int min = i;
            for(int j=i+1; j<=n-1; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.print("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortSelection(arr, n);
        System.out.print("Array after sorting: ");
        for(int j=0; j<n; j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
  