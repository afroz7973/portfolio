public class StockBuySell {
    // USING Brute Force
    // time complexity is: O(N^2)
    // public static int maxProfit(int[] arr){
    //     int maxPro = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i+1; j<arr.length; j++){
    //             if(arr[j] > arr[i]){
    //                 maxPro = Math.max(arr[j]-arr[i], maxPro);
    //             }
    //         }
    //     }
    //     return maxPro;
    // }
     

    // using optimal approach

    // public static int maxProfit(int arr[]){
    //     int maxPro = 0;
    //     int minPrice = Integer.MAX_VALUE;
    //     for(int i=0; i<arr.length; i++){
    //         minPrice = Math.min(minPrice, arr[i]);
    //         maxPro = Math.max(maxPro, arr[i]-minPrice);
    //     }
    //     return maxPro;
    // }

    public static int maxProo(int arr[]){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i]-minPrice);
        }
        return maxPro;
    }
    public static void main(String[] args) {
        // int arr[] = {3,1,5,2,8,9};
        // int maxPro = maxProfit(arr);
        // System.out.println("The maxProfit is: "+maxPro);

        // int arr[] = {7,1,5,3,6,4};
        // int maxPro = maxProfit(arr);
        // System.out.println("The maximum profit is: "+maxPro);
        int arr[] = {3,1,5,3,6,4};
        int maxPro = maxProo(arr);
        System.out.println("The maximum profit is: "+maxPro);
    }
}
