
import java.util.ArrayList;
import java.util.Arrays;
public class SetMatrixZero {
    // using brute force
    /*
     * Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the
     * matrix and M = no. of columns in the matrix.
     * Reason: Firstly, we are traversing the matrix to find the cells with the
     * value 0. It takes O(N*M). Now, whenever we find any such cell we mark that
     * row and column with -1. This process takes O(N+M). So, combining this the
     * whole process, finding and marking, takes O((N*M)*(N + M)).
     * Another O(N*M) is taken to mark all the cells with -1 as 0 finally.
     * 
     * Space Complexity: O(1) as we are not using any extra space.
     */
    // public static void markRow(ArrayList<ArrayList<Integer>> matrix ,int n,int m, int i){
    //     for(int j=0; j<m; j++){
    //         if(matrix.get(i).get(j) != 0){
    //             matrix.get(i).set(j, -1);
    //         }
    //     }
    // }

    // public static void markCol(ArrayList<ArrayList<Integer>> matrix,int n,int m,int j){
    //     for(int i=0; i<n; i++){
    //         if(matrix.get(i).get(j) != 0){
    //             matrix.get(i).set(j, -1);
    //         }
    //     }
    // }

    // static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix,int n,int m){
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix.get(i).get(j) == 0){
    //                 markRow(matrix, n, m, i);
    //                 markCol(matrix, n, m, j);
    //             }
    //         }
    //     }

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix.get(i).get(j) == -1){
    //             matrix.get(i).set(j, 0);
    //             }
    //         }
    //     }
    //     return matrix;
    // }

    // public static void markRow(ArrayList<ArrayList<Integer>> matrix,int n,int m,int i){
    //     for(int j=0; j<m; j++){
    //        if(matrix.get(i).get(j) != 0){
    //         matrix.get(i).set(j, -1);
    //        }
    //     }
    // }
    
    // public static void markCol(ArrayList<ArrayList<Integer>> matrix,int n,int m,int j){
    //     for(int i=0; i<n; i++){
    //         if(matrix.get(i).get(j) != 0){
    //             matrix.get(i).set(j, -1);
    //         }
    //     }
    // }

    // static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix,int n,int m){
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix.get(i).get(j) == 0){
    //                 markRow(matrix, n, m, i);
    //                 markCol(matrix, n, m, j);
    //             }
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix.get(i).get(j) == -1){
    //                 matrix.get(i).set(j, 0);
    //             }
    //         }
    //     }
    //     return matrix;
    // }

    // better approach
    /*
     * Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no.
     * of columns in the matrix.
     * Reason: We are traversing the entire matrix 2 times and each traversal is
     * taking O(N*M) time complexity.
     * 
     * Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M =
     * no. of columns in the matrix.
     * Reason: O(N) is for using the row array and O(M) is for using the col array.
     */
    //  static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix,int n, int m){
    //     int[] row = new int[n];
    //     int[] col = new int[m];
    //     for(int i=0; i<n;i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix.get(i).get(j) == 0){
    //                 row[i] = 1;
    //                 col[j] = 1;
    //             }
    //         }
    //     }

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(row[i] == 1 || col[j] == 1){
    //                 matrix.get(i).set(j, 0);
    //             }
    //         }
    //     }
    //     return  matrix;
    // }

    // better approcah
    /*
     * Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no.
     * of columns in the matrix.
     * Reason: In this approach, we are also traversing the entire matrix 2 times
     * and each traversal is taking O(N*M) time complexity.
     * 
     * Space Complexity: O(1) as we are not using any extra space.
     */
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix,int n,int m){
        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    matrix.get(i).set(0, 0);
                    // mark j-th column:

                    if(j != 0){
                        matrix.get(0).set(j, 0);
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j) != 0){
                    // check for col & row:

                    if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0){
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        // step 3: Finally mark the 1st col & then 1st row:

        if(matrix.get(0).get(0) == 0){
            for(int j=0; j<m; j++){
                matrix.get(0).set(j, 0);
            }
        }
        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));

        // int n = matrix.size();
        // int m = matrix.get(0).size();
        // ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);
        // System.out.print("The final matrix is: ");
        // for(ArrayList<Integer> row : ans){
        //     for(Integer ele : row){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));

        // int n = matrix.size();
        // int m = matrix.get(0).size();
        // ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);
        // System.out.print("The final matrix is: ");
        // for(ArrayList<Integer> row : ans){
        //     for(Integer ele : row){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }

        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        // int n = matrix.size();
        // int m = matrix.get(0).size();
        // ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);
        // System.out.print("The final matrix is: ");
        // for(ArrayList<Integer> row : ans){
        //     for(Integer ele : row){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);
        System.out.print("The final matrix is: ");
        for(ArrayList<Integer> row : ans){
            for(Integer ele : row){
                System.out.print(ele +" ");
            }
            System.out.println();
        }
    }
}
