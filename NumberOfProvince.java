
import java.util.ArrayList;
import java.util.List;

public class NumberOfProvince{
    /*
    time complexity: O(V+E) we visit every node and for every node we visit all of its neighbours in the DFS tRAVERSAL
    space complexity: O(N) for storing visited array and auxuliary stack space 
     */
    void dfs(int node,List<List<Integer>> adjList,boolean[] visited){
        visited[node] = true;
        for(int neighbours:adjList.get(node)){
            if(!visited[neighbours]){
                dfs(neighbours, adjList, visited);
            }
        }

    }
    
    int numProvince(int[][] adj,int v){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(adj[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);

                }
                
            }

        }
        boolean[] visited = new boolean[v];
        int count = 0;
        for(int i=0; i<v; i++){
            if(!visited[i]){
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int adj[][] = {
            {1,0,1},
            {0,1,0},
            {1,0,1}
        };
        int V = 3;
        NumberOfProvince obj = new NumberOfProvince();
        System.out.println("The number of provinces is: " + obj.numProvince(adj, V));
    }
}