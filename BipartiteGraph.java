
import java.util.ArrayList;

public class BipartiteGraph {
    // boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int
    // color[]) {
    // Queue<Integer> q = new LinkedList<>();
    // q.add(start);
    // color[start] = 0;
    // while (!q.isEmpty()) {
    // int node = q.peek();
    // q.remove();

    // for (int it : adj.get(node)) {
    // if (color[it] == -1) {
    // color[it] = 1 - color[node];
    // q.add(it);
    // } else if (color[it] == color[node]) {
    // return false;

    // }
    // }
    // }
    // return true;
    // }

    // boolean bipartiteGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // int color[] = new int[V];
    // for (int i = 0; i < V; i++) {
    // color[i] = -1;
    // }
    // for(int i=0; i<V; i++){

    // if (check(i, V, adj, color) == false) {
    // return false;
    // }
    // }
    // return true;
    // }

    // better approach
    /*
     * time complexity: O(V+2E) where v is the verices of graph,2E is for total
     * degrees as we traverse all adjacent nodes.
     * space complexity: O(3V)~O(V) space for sfs stack space color array and an
     * adjacent list.
     */

    boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        BipartiteGraph obj = new BipartiteGraph();
        boolean result = obj.isBipartite(4, adj);
        if (result) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
