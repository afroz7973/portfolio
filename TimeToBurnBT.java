
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// import java.util.Queue;
// import java.util.Set;

import java.util.*;

public class TimeToBurnBT {
    /*
     * time complexity : O(N) we perform two full traversal of tree.The first DFS to
     * build the graph,which visits each node once, taking O(N) time.The second is a
     * BFS starting from the target node to simulate the fire spreading,which also
     * takes O(N) time since each node is visited once.Therefore the total time
     * complexity is O(N)
     * 
     * space complexity: O(N) we use an adjacency list to store the graph,which
     * takes O(N) space.A visited set is used to track which nodes are burned,also
     * requiring O(N) space.Additionally,the BFS queue can hold up to O(N) nodes in
     * the worst case. so the overall space complexity is O(N)
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    int minTime(TreeNode root, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        burned = true;
                    }
                }
            }
            if (burned) {
                time++;
            }
        }
        return time;
    }

    void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null)
            return;
        if (parent != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        int target = 2;

        TimeToBurnBT obj = new TimeToBurnBT();
        int result = obj.minTime(root, target);
        System.out.println("Minimum time to burn the tree is: " + result);
    }
}
