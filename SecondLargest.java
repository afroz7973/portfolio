public class SecondLargest {
    public static int secondLargest(int[] arr,int n){
        // THIS is optimal solution find the second largest
        // time complextiy is O(N) single pass solution
        int largest = Integer.MIN_VALUE;
        int sLargest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > largest  && arr[i] > sLargest){
                sLargest = arr[i];
            }
        }
        return sLargest;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,5,9,3};
        int n = arr.length;
        int Sl = secondLargest(arr, n);
        System.out.println("Second largest is: "+Sl);
    }
}
