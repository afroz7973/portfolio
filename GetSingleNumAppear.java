public class GetSingleNumAppear {
    public static int singleNumApp(int arr[]){
        // Time Complexity: O(N), where N = size of the array.
        // Reason: We are iterating the array only once.
        // Space Complexity: O(1) as we are not using any extra space.
        
        int n = arr.length;
        int xor = 0;
        for(int i=0; i<n; i++){
            xor = xor^arr[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        int n = arr.length;
        int res = singleNumApp(arr);
        System.out.println("The single element is: "+res);
    }
}
