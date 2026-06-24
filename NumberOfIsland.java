import java.util.*;

public class NumberOfIsland {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    void bfs(int ro,int co,int[][] vis,char[][] grid){
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int i=0; i<4; i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));

                }
            }
        }



    }

    int Island(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(vis[row][col] == 0 && grid[row][col] == '1'){
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        NumberOfIsland obj = new NumberOfIsland();
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        int result = obj.Island(grid);
        System.out.println("The number of island is: " + result);
    }
}
