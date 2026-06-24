public class SecondLarSmall {
    public static int secondLargest(int[] arr,int n){
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && arr[i] > slargest){
                slargest = arr[i];
            }
        }
        return slargest;
    }    
    public static int secondSmallest(int[] arr,int n){
        int smallest = Integer.MAX_VALUE;
        int ssmallest = Integer.MAX_VALUE;
    
        for(int i=0; i<n; i++){
            if(arr[i] < smallest){
               ssmallest = smallest;
               smallest = arr[i];
           }
           else if(arr[i] != smallest  && arr[i] < ssmallest){
            ssmallest = arr[i];
           }
        }
        return ssmallest;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,7,5};
        int n = arr.length;
        int sL = secondLargest(arr, n);
        int sS = secondSmallest(arr, n);
        System.out.println("Second largest is: "+sL);
        System.out.println("Second smallest is: "+sS);
    }
}

