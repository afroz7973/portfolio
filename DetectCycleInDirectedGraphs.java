
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphs {
    boolean hasCycle(int V,List<List<Integer>> adj){
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
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return cnt != V;
    }
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new LinkedList<>();
        for(int i=0; i<V; i++){
            adj.add(new LinkedList<>());
        }
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        DetectCycleInDirectedGraphs obj = new DetectCycleInDirectedGraphs();
        boolean resul = obj.hasCycle(V, adj);
        if(resul){
            System.out.println("Cycle exist!");
        }
        else{
            System.out.println("Cycle Doesnot exist!");
        }
    }
}
