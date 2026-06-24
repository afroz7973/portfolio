
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    /*
     * time complexity: O(V+E) where V is the number of vertices and E is the number
     * of edges.Each node is visited once O(V).Each edge is explored once(undirected
     * graph effectively,but constants are ignored).O(E).so total O(V+E)
     * space complexity: O(V)
     */
    ArrayList<Integer> bfsTraversal(int V,ArrayList<Integer>[]adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int it:adj[node]){

                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);

                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 3));
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].addAll(Arrays.asList(1));
        adj[4].addAll(Arrays.asList(2));

        BFSGraph obj = new BFSGraph();
        ArrayList<Integer> result = obj.bfsTraversal(V, adj);
        System.out.println(result);
    }
}
