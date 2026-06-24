
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountComponents {
    /*
     * time complexity: O(V+E) each vertex is visited once and each edges is
     * processed at most twice (once from each node)
     * space complexity: O(V+E) to build adjacency list
     */
    int cntComponents(int v,int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[v];
        int components = 0;
        for(int i=0; i<v; i++){
            if(!visited[i]){
                components++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int nbr:adj.get(node)){
                        if(!visited[nbr]){
                            visited[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }
            }

        }
        return components;

    }
    public static void main(String[] args) {
        int v = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{4,5}};
        CountComponents obj = new CountComponents();
        System.out.println("The number of connected componenets: " + obj.cntComponents(v, edges));
    }
}
