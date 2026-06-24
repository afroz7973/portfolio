public class SubArraywithPosNeg {
    public static int sumWithPosNeg(int[]arr,int k){
        // brute force 
        int n = arr.length;
        int len = 0;
        for(int i=0; i<n; i++){ // starting index
            for(int j=i; j<n; j++){ // ending index
                int sum = 0;
                for(int K=i; K<=j; K++){
                    sum += arr[K];
                }
                if(sum == k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int arr[] = {-1,1,1};
        int k = 1;
        int res = sumWithPosNeg(arr, k);
        System.out.println("The length of longest array with positive and negative is: "+res);
    }
}
