
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class DistOfNearestCell1 {

    // class Node{
    //     int first;
    //     int second;
    //     int third;

    //     public Node(int first,int second,int third){
    //         this.first = first;
    //         this.second = second;
    //         this.third = third;
    //     }
    // }

    // int[][] nearestDist(int[][] grid){
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] vis = new int[n][m];
    //     int[][] dist = new int[n][m];
    //     Queue<Node> q = new LinkedList<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(grid[i][j] == 1){
    //                 q.add(new Node(i, j, 0));
    //                 vis[i][j] = 1;
    //             }
    //             else{
    //                 vis[i][j] = 0;
    //             }
    //         }
    //     }

    //     int delRow[] = {-1,0,1,0};
    //     int delCol[] = {0,1,0,-1};

    //     while(!q.isEmpty()){
    //         int row = q.peek().first;
    //         int col = q.peek().second;
    //         int steps = q.peek().third;
    //         q.remove();
    //         dist[row][col] = steps;

    //         for(int i=0; i<4; i++){
    //             int nrow = row+delRow[i];
    //             int ncol = col+delCol[i];
    //             if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && vis[nrow][ncol] == 1){
    //                 q.add(new Node(nrow, ncol, steps+1));

    //             }
    //         }
    //     }
    //     return dist;
    // }

    // better appraoch
    /*
     * time complexity: O(N*M)+O(N*M*4)~O(N*M) the bfs function will be called for
     * (N*M) nodes,and every node we are traversing for 4 neighbours,so it will take
     * O(N*M*4) time.
     * space complexity: O(N*M)+O(N*M)+O(N*M)~O(N*M),for visited array,distance matrix,and queue space takes up N*M location at max.
     *      */

    int[][] nearestDist(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];
            dist[row][col] = steps;

            for(int i=0; i<4; i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow,ncol,steps+1});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,0,0},
            {1,0,1}
        };
        DistOfNearestCell1 obj = new DistOfNearestCell1();
        int[][] result = obj.nearestDist(grid);
        for(int[] row:result){
            System.out.println(Arrays.toString(row));
        }
    }
}
