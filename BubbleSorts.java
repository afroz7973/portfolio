
import java.util.Scanner;
public class BubbleSorts {
    public static void sortBubble(int[] arr, int n){
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            
        }
        // System.out.print("Array after sorting: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
    }
    public static void main(String[] args) {
        // int arr[] = {5,8,3,9,6};
        // int n = arr.length;
        // System.out.print("Array before sorting: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        // sortBubble(arr, n);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortBubble(arr, n);
        System.out.print("Array after sorting: ");
        for(int j=0; j<n; j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
