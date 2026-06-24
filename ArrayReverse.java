
import java.util.Scanner;

public class ArrayReverse {
    public static void printArray(int arr[],int n){
        System.out.print("Reversed array: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void revArray(int[] arr,int start, int end){
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            revArray(arr, start+1, end-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the array element: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();

        }
        revArray(arr, 0, n-1);
        printArray(arr, n);
    }
}
