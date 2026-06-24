
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumOfDistinctIsland {
    

    // void dfs(int row,int col,int[][] vis,int[][] grid,ArrayList<String> vec,int row0,int col0){
    //     vis[row][col] = 1;
    //     vec.add(toString(row-row0, col-col0));
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int delRow[] = {-1,0,1,0};
    //     int delCol[] = {0,1,0,-1};
    //     for(int i=0; i<4; i++){
    //         int nrow = row+delRow[i];
    //         int ncol = col+delCol[i];
    //         if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
    //             dfs(nrow, ncol, vis, grid, vec, row0, col0);
    //         }
    //     }
    // }

    // String toString(int r,int c){
    //     return Integer.toString(r) + " " + Integer.toString(c);

    // }

    // int countDistIsland(int row,int col,int[][] grid){
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] vis = new int[n][m];
    //     HashSet<ArrayList<String>> st = new HashSet<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(vis[i][j] == 0 && grid[i][j] == 1){
    //                 ArrayList<String> vec = new ArrayList<>();
    //                 dfs(i, j, vis, grid, vec, i, j);
    //                 st.add(vec);
    //             }
    //         }
    //     }
    //     return st.size();
    // }

    // better approach
    /*
     * time complexity: O(NXM) DFS traversal and marking visited cells dominate
     * space complexity: O(NXM) or visited grid and set storing unique island shapes.
     */

    void dfs(int row,int col,int baseRow,int baseCol,int [][] grid,boolean[][] vis,List<String> shape){
        vis[row][col] = true;
        shape.add((row-baseRow) + "_" + (col-baseCol));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        for(int i=0; i<4; i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                dfs(nrow, ncol, baseRow, baseCol, grid, vis, shape);
            }
        }
    }

    int countDistIsland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> st = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, grid, vis, shape);
                    st.add(shape);
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 }
        };

        NumOfDistinctIsland obj = new NumOfDistinctIsland();
        int result = obj.countDistIsland(grid);
        System.out.println("The number of distinct island is: " + result);
    }
}
