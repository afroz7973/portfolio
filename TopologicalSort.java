
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    // DFS approach
    /*
     * Time Complexity: O(V + E)
     * Space Complexity: O(V) (for vis, stack, and recursion stack)
     */
    // void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
    //     vis[node] = 1;
    //     for(int it:adj.get(node)){
    //         if(vis[it] == 0){
    //             dfs(it, vis, st, adj);
    //         }
    //     }
    //     st.push(node);
    // }

    //  int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
    //     int vis[] = new int[V];
    //     Stack<Integer> st = new Stack<>();
    //     for(int i=0; i<V; i++){
    //         if(vis[i] == 0){
    //             dfs(i, vis, st, adj);
    //         }
    //     }
    //     int ans[] = new int[V];
    //     int i = 0;
    //     while(!st.isEmpty()){
    //         ans[i++] = st.peek();
    //         st.pop();
    //     }
    //     return ans;
    // }

    // using bfs (also called kahn's algorithm)
    /*
     * time complexity:O(V+E) bcz we visite each vertex exactly once and process all
     * outgoing edges from each vertex exactly once. The in-degree calculation takes
     * O(E) and each vertec is enqueued and dequeued exactly once in O(V) .Thus
     * total time is linear in the sum of vertex and edges.
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

        int topo[] = new int[V];
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

        TopologicalSort obj = new TopologicalSort();
        int[] result = obj.topoSort(V, adj);
        System.out.print("Topological sort: ");
        for(int node:result){
            System.out.print(node + " ");
        }
    }
}
