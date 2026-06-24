
public class SorroundedRegionOWithX {
    // void dfs(int row,int col,int[][] vis,char[][] mat,int[] delRow,int[] delCol){
    //     vis[row][col] = 1;
    //     int n = mat.length;
    //     int m = mat[0].length;

    //     for(int i=0; i<4; i++){
    //         int nrow = row+delRow[i];
    //         int ncol = col+delCol[i];

    //         if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && vis[nrow][ncol] == 'O'){
    //             dfs(nrow, ncol, vis, mat, delRow, delCol);

    //         }
    //     }
    // }

    // char[][] fill(int n,int m,char[][] mat){
    //     int delRow[] = {-1,0,1,0};
    //     int delCol[] = {0,1,0,-1};
    //     int vis[][] = new int[n][m];

    //     for(int j=0; j<m; j++){
    //         if(vis[0][j] == 0 && mat[0][j] == 'O'){
    //             dfs(0, j, vis, mat, delRow, delCol);
    //         }
    //         if(vis[n-1][j] == 0 && mat[n-1][j] == 'O'){
    //             dfs(n-1, j, vis, mat, delRow, delCol);
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         if(vis[i][0] == 0 && mat[i][0] == 'O'){
    //             dfs(i, 0, vis, mat, delRow, delCol);
    //         }
    //         if(vis[i][m-1] == 0 && mat[i][m-1] == 'O'){
    //             dfs(i, m-1, vis, mat, delRow, delCol);
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(vis[i][j] == 0 && mat[i][j] == 'O'){
    //                 mat[i][j] = 'X';
    //             }
    //         }
    //     }
    //     return mat;

    // }

    // BETTER approach
    /*
     * time complexity:O(NXM) since each cell is visited at most once during the DFS
     * traversal and once during final traversal.
     * space complexity: O(NXM) due to the visited matrix and recursion stack in the worst case.
     */

    void dfs(int row,int col,int[][] vis,char[][] mat,int[] delRow,int[] delCol){
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<4; i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, mat, delRow, delCol);
            }
        }
    }

    char[][] fill(int n,int m,char[][] mat){
        if(n == 0 || m == 0) return mat;

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int[][] vis = new int[n][m];
        for(int j=0; j<m; j++){
            if(vis[0][j] == 0 && mat[0][j] == 'O'){
                dfs(0, j, vis, mat, delRow, delCol);
            }
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O'){
                dfs(n-1, j, vis, mat, delRow, delCol);
            }
        }
        for(int i=0; i<n; i++){
            if(vis[i][0] == 0 && mat[i][0] == 'O'){
                dfs(i, 0, vis, mat, delRow, delCol);
            }
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O'){

                dfs(i, m-1, vis, mat, delRow, delCol);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && mat[i][j] == 'O'){
                    mat[i][j] = 'X';

                }
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        char[][] mat = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' }
        };
        SorroundedRegionOWithX obj = new SorroundedRegionOWithX();
        char[][] ans = obj.fill(mat.length, mat[0].length, mat);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();

        }
    }
}
