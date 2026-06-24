
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class DetectCycleInUndirected {
    /*
     * time complexity: O(N+2E)+O(N) where N is number of nodes,2E is for total
     * degree as we traverse all adjacent nodes.In all the cases of connected
     * components of a graph,it will take another O(N) time.
     * space complexity: O(N)+O(N)~O(N) space for queue data structure and visited array.
     */

    
    class Node{
        int first;
        int second;
        public Node(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    boolean checkCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean[] vis,int parent[]){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;

        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for(Integer it:adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                else if(par != it) return true;
            }

        }
        return false;
    }

    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        int parent[] = new int[V];
        Arrays.fill(parent, -1);    
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                if(checkCycle(adj, i, vis, parent)){
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

        DetectCycleInUndirected obj = new DetectCycleInUndirected();
        boolean ans = obj.isCycle(4, adj);
        if(ans){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}
