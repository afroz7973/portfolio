public class RowWithMaxNoOfOne {
    // brute force
    /*
     * time complexity: O(mxn) where n is the row number and m is the column
     * number.Since we are applying nested loop running for n and m times
     * respectively.
     * space complexity: O(1),Since we are not using any extra space to solve this
     * problem
     * 
     */
    // public int maxNoOfRows(int matrix[][],int n,int m){
    // int max_count = 0;
    // int indx = -1;
    // for(int i=0; i<n; i++){
    // int count_ones = 0;
    // for(int j=0; j<m; j++){
    // count_ones += matrix[i][j];
    // }
    // if(count_ones > max_count){
    // max_count = count_ones;
    // indx = i;
    // }
    // }
    // return indx;
    // }

    // optimal approach
    /*
     * time complexity: O(nxlogm) where n is the number of row and m is the number
     * of column.we are using a loop running for n times to traverse the rows.Then
     * we are applying binary search on each row with m column.
     * space complexity: O(1),we are not using any extra space to solve this
     * problem.
     */
    // public int upperBound(int arr[], int n, int x) {
    //     int low = 0;
    //     int high = n - 1;
    //     int ans = n;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (arr[mid] >= x) {
    //             ans = mid;
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return ans;
    // }

    // public int maxNoOfRows(int matrix[][],int n,int m){
    //     int max_count = -1;
    //     int indx = 0;
    //     for(int i=0; i<n; i++){
    //         int count_ones = m-upperBound(matrix[i], m, 1);
    //         if(count_ones > max_count){
    //             max_count = count_ones;
    //             indx = i;
    //         }
    //     }
    //     return indx;
    // }

    // public int maxNoOfRows(int matrix[][],int n ,int m){
    //     int max_count = -1;
    //     int indx = 0;
    //     for(int i=0; i<n; i++){
    //         int count_ones = 0;
    //         for(int j=0; j<m; j++){
    //             count_ones += matrix[i][j];
    //         }
    //         if(count_ones > max_count){
    //             max_count = count_ones;
    //             indx = i;
    //         }
    //     }
    //     return indx;
    // }

    // optimal approach

    public int upperBound(int arr[],int n,int x){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int maxNoOfRows(int matrix[][],int n,int m){
        int max_count = -1;
        int indx = 0;
        for(int i=0; i<n; i++){
            int count_ones = m-upperBound(matrix[i], m, 1);
            if(count_ones > max_count){
                max_count = count_ones;
                indx = i;
            }
        }
        return indx;
    }
    public static void main(String[] args) {
        int arr[][] = { { 0,1,1 }, { 1,1,1 }, { 0, 1, 1 } };
        int n = 3;
        int m = 3;
        RowWithMaxNoOfOne obj = new RowWithMaxNoOfOne();
        int result = obj.maxNoOfRows(arr, n, m);
        System.out.println("The row with maximum number is: " + result);
    }
}
