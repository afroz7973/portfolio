


public class MedianOfRowWiseSortedMat {
    // brute approach
    /*
     * time complexity: O(M*N*(Log(M*N))), sorting the linear array takes the time
     * complexity of O(M*N(log M*N));
     * space complexity: O(M*N) to create linear array 
     */
    // public int findMedian(int matrix[][]){
        // int n = matrix.length;
        // int m = matrix[0].length;
        // List<Integer>ele = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         ele.add(matrix[i][j]);
        //     }
        // }
    //     for(int[] row:matrix){
    //         for(int val:row){
    //             ele.add(val);
    //         }
    //     }
    //     Collections.sort(ele);
    //     int n = ele.size();
    //     return ele.get(n/2);
    // }

    // public int findMedian(int matrix[][]){
    //     List<Integer> elements = new ArrayList<>();
    //     for(int[] rows:matrix){
    //         for(int val:rows){
    //             elements.add(val);
    //         }
    //     }
    //     Collections.sort(elements);
    //     int n = elements.size();
    //     return elements.get(n/2);
    // }

    // optimal approach
    /*
     * time complexity: O(rows*log(max-min)*log(cols)),Binary search runs on the
     * value space from min to max of the matrix and for each mid in BS, we count
     * how many numbers are less than or equal to mid.
     * space complexity: O(1),constant extra space is used
     */
    // public int countLessEqual(int arr[],int m){
    //     int low = 0;
    //     int high = arr.length;
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] <= m){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return low;
    // }

    // public int findMedian(int matrix[][]){
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int low = matrix[0][0];
    //     int high = matrix[0][m-1];
    //     for(int i=0; i<n; i++){
    //         low = Math.min(low, matrix[i][0]);
    //         high = Math.max(high, matrix[i][m-1]);
    //     }
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         int count = 0;
    //         for(int i=0; i<n; i++){
    //             count += countLessEqual(matrix[i], mid);
    //         }
    //         if(count < (n*m+1)/2){
    //             low = mid+1;
    //         }
    //         else{
    //             high = mid-1;
    //         }
    //     }
    //     return low;
    // }

    // brute force

    // time complexity: O(M*N*(log(M*N))) sorting the linear array takes time complexity of O(M*N*(log(M*N)))
    // space complexity: O(M*N) to create a linear array
    // public int findMedian(int matrix[][]){
    //     List<Integer> elements = new ArrayList<>();
    //     for(int[] row:matrix){
    //         for(int val:row){
    //             elements.add(val);
    //         }
    //     }
    //     Collections.sort(elements);
    //     int n = elements.size();
    //     return elements.get(n/2);
    // }

    // optimal approach
    /*
     * time complexity: O(n*log(max-min)*log(m)) Binary search runs on the value
     * space from min to max of the matrix and for each mid in binary search we
     * count how many numbers are less than or equal to mid
     * space complexity: O(1) constant extra space is used
     */
    public int upperBound(int arr[],int m){
        int low = 0;
        int high = arr.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] <= m){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }

    public int findMedian(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[0][m-1];
        for(int i=0; i<m; i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m-1]);
        }
        while(low <= high){
            int mid = (low+high)/2;
            int count = 0;
            for(int i=0; i<n; i++){
                count += upperBound(matrix[0], mid);
            }
            if(count < (n*m-1)/2){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int matrix[][] = {{2,5,8},{4,6,9},{6,7,9}};
        MedianOfRowWiseSortedMat obj = new MedianOfRowWiseSortedMat();
        int result = obj.findMedian(matrix);
        System.out.println("The median of the matrix is: "+result);
    }
}
