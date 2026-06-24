public class FindPeakEleII {
    // optimal approach
    /*
     * time complexity: O(NXlogM) where N is the number of rows in the matrix, M is
     * the number column in the each row. The complexity arises because binary
     * search is performed on the columns and for each mid column, a linear search
     * through the rows is executed to find the maximum element.
     * space complexity: O(1) no additonal space is used to solve this problem
     */
    

    public int peakEle(int arr[][],int cols){
        int n = arr.length;
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0; i<n; i++){
            if(arr[i][cols] > maxVal ){
                maxVal = arr[i][cols];
                index = i;
            }
        }
        return index;
    }

    public int[] peakGridEle(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int rows = peakEle(matrix, mid);
            int left = mid-1 >= 0 ? matrix[rows][mid-1] : Integer.MIN_VALUE;
            int right = mid+1 < m ? matrix[rows][mid+1] : Integer.MIN_VALUE;
            if(matrix[rows][mid] > left && matrix[rows][mid] > right){
                return new int[]{rows,mid};
            }
            else if(left > matrix[rows][mid]){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {2,5,7,9},
            {5,8,9,10},
            {8,9,10,25},
            {9,10,25,30}
        };
        FindPeakEleII obj = new FindPeakEleII();
        int result[] = obj.peakGridEle(matrix);
        System.out.println("The row of the peak element is "+result[0]+" and the column of the peak element is: "+result[1]);
    }
}
