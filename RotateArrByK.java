

public class RotateArrByK {
    // public static void leftRotate(int[] arr,int n, int d){
    //     d = d % n;
    //     int temp[] =  new int[d];
    //     for(int i=0; i<d; i++){
    //         temp[i] = arr[i];
    //     }
    //     for(int i=d; i<n; i++){ 
    //         arr[i-d] = arr[i]; // shifting
    //     }
    //     for(int i=n-d; i<n; i++){
    //         arr[i] = temp[i-(n-d)]; // place back temporary into array
    //     }

    // }
    // public static void reverseRight(int[] arr,int start,int end){
    //     while(start <= end){
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }

    // public static void  rotateRight(int[] arr,int n,int k){
    //     reverseRight(arr, 0, n-k-1);
    //     reverseRight(arr, n-k, n-1);
    //     reverseRight(arr, 0, n-1);
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
    public static void rotateLeft(int arr[],int n, int k){
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
        // leftRotate(arr, n, d);
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        // int arr[] = {1,2,3,4,5,6,7};
        // int n = 7;
        // int k = 2;
        // rotateRight(arr, n, k);
        // System.out.print("Array after rotating right: ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();

        int arr[] = {1,2,3,4,5,6,7};
        int n = 7;
        int k = 2;
        rotateLeft(arr, n, k);
        System.out.print("Array after rotating left: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
