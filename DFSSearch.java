
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSSearch {
    /*
     * time complexity:O(V+E) each vertex is visited once and every edge is checked
     * once in the adjacency matrix
     * space complexity: O(V) additional amount of space is required for recursion stack.
     */

    // void dfs(int v,List<Integer>[] adj,boolean[] visited,List<Integer> result){
    //     visited[v] = true;
    //     result.add(v);

    //     for(int u:adj[v]){
    //         if(!visited[u]){
    //             dfs(u, adj, visited, result);
    //         }

    //     }
    // }

    void dfs(int v,List<Integer>[] adj,boolean[] visited,List<Integer> result){
        visited[v] = true;
        result.add(v);

        for(int u:adj[v]){
            if(!visited[u]){
                dfs(u, adj, visited, result);

            }

        }

    }
    public static void main(String[] args) {
        int V = 5;
        List<Integer>[] adj = new ArrayList[V];
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }

        adj[0].addAll(Arrays.asList(1,2));
        adj[1].addAll(Arrays.asList(0,3));
        adj[2].addAll(Arrays.asList(0,4));
        adj[3].addAll(Arrays.asList(1));
        adj[4].addAll(Arrays.asList(2));

        boolean[] visited = new boolean[V];

        List<Integer> result = new ArrayList<>();
        DFSSearch obj = new DFSSearch();

        obj.dfs(0, adj, visited, result);
        for(int x:result){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
