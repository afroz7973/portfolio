public class SecondSmallest {
    public static int secondSmallest(int[] arr,int n){
        // its time complexity will be O (N),
        // single pass solution
        // Integer.MAX_VALUE is the largest integer (2,147,483,647).
        // -1 works only in limited cases
        
        int small = Integer.MAX_VALUE;
        int ssmall = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] < small){
                ssmall = small;
                small = arr[i];
            }
            else if(arr[i] != small && arr[i] < ssmall){
                ssmall = arr[i];
            }
        }
        return ssmall;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,7,4};
        int n = arr.length;
        int Ss = secondSmallest(arr, n);
        System.out.println("Second smallest is: "+Ss);
    }
}
