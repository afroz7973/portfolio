public class Insertion_Sort {
    public static void insertionSort(int[] arr, int n){
        for(int i=0; i<=n-1; i++){
            int j = i;
            while(j>0 && arr[j-1] >arr[j]){
                // temp
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.print("After insertion sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,8,4,9,2};
        int n = arr.length;
        System.out.print("Before insertion sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        insertionSort(arr, n);
    }
}
