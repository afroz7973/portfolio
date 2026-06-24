

public class SearchIn2DMatrix {
    // brute force
    /*
     * time complexity: O(nxm), we are traversing the entire matrix with "n" rows
     * and "m" columns.In the worst case we may end up visisting each cells once if
     * the target is not present.so the total number of operation is proportional to
     * the number of of element in the matrix.
     * space complexity: O(1) we are not using any extra space.The algorithm uses a constant amount of extra memory regardless of the size of the memory just loop
     * variables and the target. Therefore the space complexiyt is constant
     */
    // public boolean searchIn2D(int matrix[][], int target) {
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if (matrix[i][j] == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // better approach
    /*
     * time complexity: O(n*logm) we go through each of the 'n' rows once.For any
     * valid row where the target can exist, we apply binary search which takes
     * O(log m).so overall time complexity is O(n*logm).
     * space complexity: O(1) no extra space is used just a few integer variables or looping and binary search. Space complexity is constant.
     */
    // public boolean binarySearchs(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             return true;
    //         }
    //         else if(target > arr[mid]){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return false;
    // }

    // public boolean searchIn2D(int matrix[][],int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i=0; i<n; i++){
    //         if(matrix[i][0] <= target && target <= matrix[i][m-1]){
    //             return binarySearchs(matrix[i], target);
    //         }
    //     }
    //     return false;
    // }

    // optimal approach
    /*
     * time complexity: O(log(NXM)) Where N is the given row number and M is the
     * given column number. we are applying binary search on the imaginary 1D array
     * of NXM.
     * space complexity: O(1)  we are not using any extra space to solve this problem.
     */
    // public boolean searchIn2D(int matrix[][],int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int low = 0;
    //     int high = m*n-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         int row = mid / m;
    //         int col = mid % m;
    //         if(matrix[row][col] == target){
    //             return true;
    //         }
    //         else if( matrix[row][col] < target){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return false;
    // }

    // brute force 
    /*
     * time complexity: O(NXM) we are traversing the entire array with 'N' rows and
     * 'M' columns.In the worst case we may end up visisting every cell onceif the
     * target is not present.
     * so the total number of operation is proportional to the number of elements in
     * the matrix.
     * space complexity: O(1),We are not using any extra space to solve this problem.The algorithm uses the constant amount of extra memory regardless of the size of the matrix just loop variables and the target.Therefore the space complexity is constant.
     * 
     */
    // public boolean searchIn2D(int matrix[][],int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] == target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // optimal approach
    /*
     * time complexity:O(NXlogM) we go through each "N" rows once.For any valid row
     * where the target can exist, we apply binary search which takes O(logM).So
     * overall time complexity=O(NxlogM).
     * space complexity: O(1),No extra space is used just a few integer variable for looping and binary search.so space is constant.
     */
    // public boolean binarySearchs(int arr[],int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public boolean searchIn2D(int matrix[][],int target){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     for(int i=0; i<n; i++){
    //         if(matrix[i][0] <= target && target <= matrix[i][m-1]){
    //             return binarySearchs(matrix[i], target);
    //         }
    //     }
    //     return false;
    // }

    // optimal approach
    /*
     * time complexity:O(log(NXM)) where n is the number of row and m is the number
     * columns.We are applying binary search on the imaginary 1d array of size NXM.
     * space complexity: O(1) as we are not using any extra space to solve this problem.
     */
    public boolean searchIn2D(int matrix[][],int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid / m;
            int cols = mid % m;
            if(matrix[row][cols] == target){
                return true;
            }
            else if(target <= matrix[row][cols]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = { { 2, 4, 5, 6 }, { 8, 10, 15, 20 }, { 22, 25, 36, 40 } };
        int target = 250;
        SearchIn2DMatrix obj = new SearchIn2DMatrix();
        boolean result = obj.searchIn2D(matrix, target);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
