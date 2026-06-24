public class SecondLargestEle {
    // brute force approach
    // time complexity O(NlogN)
    // this is approach to find second smallest and second largest

    // public static void getLargest(int[] arr,int n){
    //     if(n == 0 || n == 1){
    //         System.out.println(-1);
    //         System.out.println(" ");
    //         System.out.println(-1);
    //         System.out.println("\n");
    //     }
    //     Arrays.sort(arr);
    //     int small = arr[1];
    //     int large = arr[n-2];
    //     System.out.println("Second smallest is: "+small);
    //     System.out.println("Second largest is: "+large);
    // }

    // better approach
    // time complexity O(2N)
    // it is better than brute force

    //  static private void getSmallest(int[] arr,int n){
    //     if(n == 0 || n == 1){
    //         System.out.println(-1);
    //         System.out.println(" ");
    //         System.out.println(-1);
    //         System.out.println("\n");
    //     }
    //     int small = Integer.MAX_VALUE;
    //     int second_small = Integer.MAX_VALUE;

    //     int large = Integer.MIN_VALUE;
    //     int second_large = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         small = Math.min(small, arr[i]);
    //         large = Math.max(large, arr[i]);
    //     }
    //     for(int i=0; i<n; i++){
    //         if(arr[i] < second_small && arr[i] != small){
    //             second_small = arr[i];
    //         }
    //         if(arr[i] > second_large && arr[i] != large){
    //             second_large = arr[i];
    //         }
    //     }
    //     System.out.println("Second smallest is: "+second_small);
    //     System.out.println("Second largets is: "+second_large);
    // }

    // optimal approach
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
            if(arr[i] > ssmallest){
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] != smallest && arr[i] < ssmallest){
                ssmallest = arr[i];

            }
        }
        return ssmallest;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,4,6,7,5};
        // int n = arr.length;
        // getLargest(arr, n);

        // int arr[] = {1,2,4,6,7,5};
        // int n = arr.length;
        // getSmallest(arr, n);

        int arr[] = {5,9,1,2,5,7};
        int n = arr.length;
        int sL = secondLargest(arr, n);
        int sS = secondSmallest(arr, n);

        System.out.println("Second largest is: "+sL);
        System.out.println("Second smallest is: "+sS);
    }
}
