
import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    // boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int pathVis[]){
    //     vis[node] = 1;
    //     pathVis[node] = 1;
    //     for(int it:adj.get(node)){
    //         if(vis[it] == 0){
    //             if(dfsCheck(it, adj, vis, pathVis) == true){
    //                 return true;
    //             }
    //         }
    //         else if(pathVis[it] == 1){
    //             return true;
    //         }
    //     }
    //     pathVis[node] = 0;
    //     return false;

    // }

    // boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
    //     int[] vis = new int[V];
    //     int[] pathVis = new int[V];
    //     for(int i=0; i<V; i++){
    //         if(vis[i] == 0){
    //             if(dfsCheck(i, adj, vis, pathVis) == true){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;

    // }

    // another approach
    /*
     * time complexity: O(V+E)+O(V) where v is number of nodes and e is number of
     * edges.There can be atmost v components.so another O(V) time complexity
     * space complexity: O(2N)+O(N)~O(2N): O(2N) for two visited array and O(N) for recursive stack space
     */

    boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[]){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                if(dfsCheck(it, adj, vis, pathVis) == true){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }

    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis, pathVis) == true){
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
        boolean result = obj.isCycle(V, adj);
        if(result){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
