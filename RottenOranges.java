
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    /*
     * time complexity: O(N*M) each 
     */
    // class Pair{
    //     int row;
    //     int col;
    //     int tm;
    //     public Pair(int _row,int _col,int _tm){
    //         this.row = _row;
    //         this.col = _col;
    //         this.tm = _tm;
    //     }
    // }
    // int orangeRotting(int[][] grid){
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     Queue<Pair> q = new LinkedList<>();
    //     int[][] vis = new int[n][m];
    //     int cntFresh = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(grid[i][j] == 2){
    //                 q.add(new Pair(i, j, 0));
    //                 vis[i][j] = 2;
    //             }
    //             else{
    //                 vis[i][j] = 0;
    //             }
    //             if(grid[i][j] == 1){
    //                 cntFresh++;
    //             }

    //         }

    //     }
    //     int tm = 0;
    //     int[] drow = {-1,0,1,0};
    //     int[] dcol = {0,1,0,-1};

    //     int cnt = 0;
    //     while(!q.isEmpty()){
    //         int r = q.peek().row;
    //         int c = q.peek().col;
    //         int t = q.peek().tm;
    //         tm = Math.max(tm, t);
    //         q.remove();
    //         for(int i=0; i<4; i++){
    //             int nrow = r+drow[i];
    //             int ncol = c+dcol[i];
    //             if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
    //                 q.add(new Pair(nrow, ncol, t+1));
    //                 vis[nrow][ncol] = 2;
    //                 cnt++;

    //             }
    //         }
    //     }
    //     if(cnt != cntFresh){
    //         return -1;
    //     }
    //     return tm;
    // }

    // another approach
    /*
    time complexity:
     */
    int rottenOranges(int[][] grid){
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int count = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0){
                    total++;
                }
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int days = 0;
        while(!rotten.isEmpty()){
            int k = rotten.size();
            count += k;
            for(int i=0; i<k; i++){
                int[] pos = rotten.poll();
                int x = pos[0],y=pos[1];
                for(int d=0; d<4; d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1){
                        continue;
                    }
                    grid[nx][ny] = 2;
                    rotten.add(new int[]{nx,ny});
                }
            }
            if(!rotten.isEmpty()) days++;
        }
        return total == count ? days : -1;
    }
    public static void main(String[] args) {
        RottenOranges obj = new RottenOranges();
        int[][] grid = {
            {0,1,2},
            {1,2,1},
            {2,1,0}
        };
        int result = obj.rottenOranges(grid);
        System.out.println("The rotten oranges are: " + result);
    }
}
