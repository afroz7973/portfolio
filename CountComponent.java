
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountComponent {
    /*
     * time complexity: O(V+E) each vertext is visited exactly once and each edge is
     * processed at most twice (once from each node)
     * space complexity: O(V+E) to build adjacency list
     */
    int countComponents(int V,int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[V];
        int component = 0;
        for(int i=0; i<V; i++){
            if(!visited[i]){
                component++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int node = q.poll();

                    for(int nbr : adj.get(node)){
                        if(!visited[nbr]){
                            visited[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }
            }
        }
        return component;
    }

    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{4,5}};

        CountComponent obj = new CountComponent();
        System.out.println("Number of connected component is: " + obj.countComponents(V, edges));
    }
}
