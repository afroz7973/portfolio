public class SqrtOfNumber {

    // public int findSQRT(int n){
    //     int ans = 1;
    //     for(int i=1; i<n; i++){
    //         if(i*i <= n){
    //             ans = i;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    // brute force
    /*
     * time complexity: O(N),we are checking from every number from 1toN
     * space comlexity: O(1),since the algorithm didn't use any additional space or data structure
     */
    // public int findSQRT(int n){
    //     int ans = 1;
    //     for(int i=1; i<n; i++){
    //         if((long)(i) * i <= n){
    //             ans = i;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    // optimal approach

    // public int findSQRT(int n){
    //     int low = 1;
    //     int high = n;
    //     int ans = 1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if((mid*mid) <= n){
    //             ans = mid;
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // optimal approach
    // time complexity
    /*
     * time complexity: O(log2 N),we apply binary search own our search space to
     * reduce into half at every step
     * space comlexity: O(1),Since the algorithm doesnot use any additional space and data structure
     */
    // public int findSQRT(int n){
    //     if(n < 2) return n;
    //     int low=1;
    //     int high=n/2;
    //     int ans=0;
    //     while(low <= high){
    //         long mid = (low+high)/2;
    //         if((mid*mid <= n)){
    //             ans = (int)mid;
    //             low = (int)mid+1;
    //         }
    //         else{
    //             high = (int)mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // public int findSQRT(int n){
    //     if(n < 2) return 2;
    //     int low = 1;
    //     int high = n/2;
    //     int ans = 1;
    //     while(low <= high){
    //         long mid = (low+high)/2;
    //         if(mid*mid <=n){
    //             ans= (int)mid;
    //             low = (int) mid+1;
    //         }
    //         else{
    //             high = (int) mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // public int findSQRT(int n){
    //     if(n < 2) return n;
    //     int low = 1;
    //     int high = n/2;
    //     int ans = 1;
    //     while(low <= high){
    //         long mid = (low+high)/2;
    //         if(mid*mid <= n){
    //             ans = (int) mid;
    //             low = (int) mid+1;
    //         }
    //         else{
    //             high = (int)mid-1;
    //         }
    //     }
    //     return ans;
    // }

    // brute force

    // public int findSQRT(int n){
    //     int ans = 1;
    //     for(int i=1; i<=n; i++){
    //         if((long)(i)*i <= n){
    //             ans = i;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    // oprimal approach

    public int findSQRT (int k){
        if(k < 2) return k;
        int left = 1;
        int right = k/2;
        int ans = 1;
        while(left <= right){
            long mid = left+(right-left);
            if(mid*mid <= k){
                ans = (int) mid;
                left = (int) mid+1;
            }
            else{
                right = (int) mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int n = 37;
        // SqrtOfNumber obj = new SqrtOfNumber();
        // int result = obj.findSQRT(n);
        // System.out.println("The square root of "+ n +" is: "+result);

        int n = 25;
        SqrtOfNumber obj = new SqrtOfNumber();
        int result = obj.findSQRT(n);
        System.out.println("The square root of "+ n + " is: "+result);
    }
}
