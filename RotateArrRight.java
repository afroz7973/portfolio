
import java.util.Scanner;



public class RotateArrRight {
    // this is reversal approach to rotate by right
    // public static void reverse(int[] arr,int start,int end){
    //     // this is function to reverse element
    //     while(start <= end){
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }
    // // function to rotate k element to right
    // public static void rotateRight(int[] arr,int n, int k){
    //     // reverse first n-k element
    //     reverse(arr, 0, n-k-1);
    //     // reverse last k element
    //     reverse(arr, n-k, n-1);
    //     // reverse whole array
    //     reverse(arr, 0, n-1);
    // }

    public static void reverseLeft(int[] arr,int start,int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateLeft(int[] arr, int n, int k){
        reverseLeft(arr, 0, k-1);
        reverseLeft(arr, k, n-1);
        reverseLeft(arr, 0, n-1);
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the size of array: ");
        // int n = sc.nextInt();
        // int arr[] = new int[n];

        // System.out.print("Enter the array: ");
        // for(int i=0; i<n; i++){
        //     arr[i] = sc.nextInt();
        // }
        // System.out.print("Enter the d: ");
        // int d = sc.nextInt();
        // rotateRight(arr, n, d);
        // System.out.print("After rotating element to right: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the d: ");
        int d = sc.nextInt();
        rotateLeft(arr, n, d);
        System.out.print("Array after rotating to left: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
