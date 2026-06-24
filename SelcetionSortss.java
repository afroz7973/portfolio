public class SelcetionSortss {
    public static void sortSelection(int[] arr, int n){
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // swaping
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.print("After selection sort: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {2,88,1,9,6};
        int n = arr.length;
        System.out.print("Before selection sor: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sortSelection(arr, n);
    }
}
