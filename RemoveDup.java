public class RemoveDup {
    public static int removeDuplicates(int[] arr){
        // this is the optimal approach
        // the time complexity is O(N)
        // SPAce complexity is O(1)
        int i=0;
        for(int j=1; j<arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3,4};
        int n = removeDuplicates(arr);
        System.out.print("Array after removing duplicates: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
