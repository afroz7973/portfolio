public class SearchIn2DMatrixII {

    // brute force
    /*
     * time complexity: O(NXM) where N is the number of rows and M is the number
     * columns inorder to traverse the matrix we are using nested loops running for
     * n and n times respectively
     * space complexity: O(1) since we are not using any extra space to solve this problem
     */
    // class MatrixSearch{
    //     private int matrix[][];
    //     public MatrixSearch(int matrix[][]){
    //         this.matrix = matrix;
    //     }

    // }
    // public int[] searchIn2DII(int matrix[][],int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    // better approach
    /*
     * time complexity: O(NXlogM) where N is the number of rows and M is the number
     * of column.We are traversing all rows and it takes O(N) time complexity.and
     * for all rows we are applying binary search.So the total time complexity is:
     * (NXlogM)
     * space complexity: O(1) we are not using any extra space to solve this problem 
     */
    // public int  binarySearchs(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             return mid;
    //         }
    //         else if(target > arr[mid]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return -1;
    // }
    // public int[] searchMatII(int matrix[][],int target){
    //     int n = matrix.length;
    //     for(int i=0; i<n; i++){
    //         int cols = binarySearchs(matrix[i], target);
    //         if(cols != -1){
    //             return new int[]{i,cols};
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    // optimal approach
    /*
     * time complexity: O(N+M) where N is the number of rows and M is the number of
     * columns.We are starting traversal from (0,m-1), and at most we may end up
     * being in the cell (M-1,0). SO the total distance can be at most (N+M).So the
     * time complexity is O(N+M).
     * space complexity: O(1) since we are not using any extra space to solve this problem
     */
    public boolean searchMatII(int matrix[][],int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int rows = 0;
        int cols = m-1;
        while(rows < n && cols >= 0){
            if(matrix[rows][cols] == target){
                return true;
            }
            else if(matrix[rows][cols] < target){
                rows++;
            }
            else{
                cols--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{2,4,7,8},{5,8,9,10},{8,11,42,44},{5,8,9,20}};
        int target = 11;
        SearchIn2DMatrixII obj = new SearchIn2DMatrixII();
        boolean result = obj.searchMatII(matrix, target);
        // System.out.println("The index of "+result[0]+","+result[1]);
        if(result){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
