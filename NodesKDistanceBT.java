
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NodesKDistanceBT {
    /*
     * time complexity: O(N) where N is the number of nodes in the binary tree.We
     * visit each node exactly once when building parent map using BFS,O(N).We again
     * visit each node atmost once during the second BFS traversal from the
     * target,O(N).Hence the total time complexity is O(N).
     * 
     * space complexity: O(N) where N is the number of nodes in the binary tree.The
     * parent map stores one entry per node O(N) The queue and visited set used in
     * BFS also takes up to O(N) space in worst case. Therefore the total time
     * complexity is O(N).
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

    List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return new ArrayList<>();
        Map<TreeNode, TreeNode> parenMap = new HashMap<>();
        mapParent(root, parenMap);
        return bfsFromTarget(target, parenMap, k);
    }

    void mapParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);

            }

        }
    }

    private List<Integer> bfsFromTarget(TreeNode target, Map<TreeNode, TreeNode> parenMap, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel++ == k)
                break;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);

                }
                if (parenMap.containsKey(node) && !visited.contains(parenMap.get(node))) {
                    visited.add(parenMap.get(node));
                    queue.offer(parenMap.get(node));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);

        TreeNode target = root.left;
        int k = 2;
        NodesKDistanceBT obj = new NodesKDistanceBT();
        List<Integer> result = obj.distanceK(root, target, k);

        for(int val:result){
            System.out.println("Nodes at a distance of binary tree is: " + val + " ");

        }

    }
}
