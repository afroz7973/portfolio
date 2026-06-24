public class NthRootOfNum {

    // brute force
    /*
     * time complexity: O(M), we search for every possible numbeer from 1 to M to
     * check if it is the Nth root
     * space complexity: O(1),constant additional space is used
     */
    // public int nthRoot(int n, int m) {
    // for (int i = 1; i <= m; i++) {
    // long power = (long) Math.pow(i, n);
    // if (power == m) {
    // return i;
    // }
    // if (power > m) {
    // break;
    // }
    // }
    // return -1;
    // }

    // optimal approach
    /*
     * time complexity: O(log2 N) we search every possible number from 1 to N to
     * check if it is the Nth root
     * space complexity: O(1),constant additional space is used
     */

     /*
      * time complexity; O(M),we search for every possible number from 1toM to check
      * if it is in the Nth root
      * space complexity: O(1),constant additional space is used
      */
    // public int nthRoot(int n,int m){
    //     for(int i=1; i<=m; i++){
    //         long power = (long) Math.pow(i, n);
    //         if(power == m) return i;
    //         if(power > m) break;
    //     }
    //     return -1;
    // }

    //optimal approach
    /*
     * time complexity: O(log2 M) ,we search for every possible number from 1 to M
     * to check if it is the Nth root
     * space complexity: O(1) constant additional space is used
     */
    public int nthRoot(int N,int M){
        int low = 1;
        int high = M;
        while(low <= high){
            int mid = (low+high)/2;
            long ans = 1;
            for(int i=0; i<N; i++){
                ans *= mid;
                if(ans > M) break;
            }
            if(ans == M) return mid;
            if(ans < M) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        NthRootOfNum obj = new NthRootOfNum();
        int result = obj.nthRoot(n,m);
        System.out.println("The nth root of " + m + " is: " + result);
    }
}
