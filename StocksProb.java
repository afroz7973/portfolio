public class StocksProb {
    // public static int maxProfit(int arr[]){
    //     // using optimal approach
    //     // O(N)
    //     int maxPro = 0;
    //     int minPrice = Integer.MAX_VALUE;
    //     for(int i=0; i<arr.length; i++){
    //         minPrice = Math.min(minPrice, arr[i]);
    //         maxPro = Math.max(maxPro, arr[i]-minPrice);
    //     }
    //     return maxPro;
    // }

    // public static int maxStockPro(int arr[]){
    //     // using brute force
    //     // Time complexity: O(N^2)
    //     int maxPofit = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i+1; j<arr.length; j++){
    //             if(arr[j] > arr[i]){
    //                 maxPofit = Math.max(arr[j]-arr[i],maxPofit);
    //             }
    //         }
    //     }   
    //     return maxPofit;
    // }

    // using optimal approach
    // Time complexity: O(N)

    public static int stockProft(int arr[]){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i]-minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        // int arr[] = {3,1,5,3,6,4};
        // int maxPro = maxProfit(arr);
        // System.out.println("The maximum profit is: "+maxPro);
        // int arr[] = {3,1,5,3,6,4};
        // int maxPofit = maxStockPro(arr);
        // System.out.println("The maximum profit is: "+maxPofit);

        int arr[] = {3,1,5,3,6,4};
        int maxPofit = stockProft(arr);
        System.out.println("The maximum profit is: "+maxPofit);
    }
}
