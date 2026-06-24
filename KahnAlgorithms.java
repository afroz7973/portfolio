
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithms {
    /*
     * time complexity: O(V+E) bcz we visit each vertex exactly once and process all
     * outgoing edges from each vertex exactly once. The in-degree calculation takes
     * O(E) and each vertex is enqueued and dequeued exactly once in O(V). tHUS
     * total time is in linear in the sum of vertices and edges.
     * space complexity: O(V+E) bcz we store the adjacency list which takes O(E)
     * space,the in-degree array which takes O(V) vertices at a time.
     */
    int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int indx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[indx++] = node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        KahnAlgorithms obj = new KahnAlgorithms();
        int result[] = obj.topoSort(V, adj);
        System.out.print("Topological sort are: ");
        for(int node:result){
            System.out.print(node + " ");
        }
    }
}
