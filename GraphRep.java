
import java.util.ArrayList;
import java.util.Scanner;



public class GraphRep {
    // public static void main(String[] args) {
    
    //     // for adjacency matrix
    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter the number of nodes: ");
    //     int n = sc.nextInt();
    
    //     int[][] adj = new int[n+1][n+1];
    //     for(int i=0; i<n; i++){
    //         System.out.print("Enter values for now: " + i + ":");
            
    //         for(int j=1; j<=n; j++){
    //             adj[i][j] = sc.nextInt();
    //         }
    //     }
    //     System.out.print("Adjancency matrix: ");
    //     for(int i=1; i<=n; i++){
    //         for(int j=1; j<=n; j++){
    //             System.out.print(adj[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    // adjacency list
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<=m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            // for undirected graph
            // adj[v].add(u); 

        }
    }
}
