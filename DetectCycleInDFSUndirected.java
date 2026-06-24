
import java.util.ArrayList;

public class DetectCycleInDFSUndirected {
    /*
     * time complexity:O(V+2E) we build the adjacency list and explored all the
     * edges and visit all the vertices once during the DFS traversal
     * space complexity: O(V+2E) additional space is used to store adjacency list,visited array and recursive call stack for DFS traversal.
     */
    boolean dfs(int node,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                if(dfs(neighbour, node, vis, adj)){
                    return true;
                }
                else if(neighbour != parent) return true;
            }
        }
        return false;
    }

    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)){
                    return true;
                }

            }
        }
        return false;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<4; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        DetectCycleInDFSUndirected obj = new DetectCycleInDFSUndirected();
        boolean result = obj.isCycle(4, adj);
        if(result){
            System.out.println("1");

        }
        else{
            System.out.println("0");
        }
    }
}
