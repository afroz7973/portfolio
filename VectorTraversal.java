
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VectorTraversal {
    /*
     * time complexity:O(N*log2N*log2N*log2N) where N is the nodes in the binary
     * tree.Postorder traversal is performed using a time complexity of O(N),since
     * each node is visited exactly once.Multiset operation for inserting
     * overlapping nodes at specific vertical and horizontal levels takes O(log2N)
     * time.Map opertation involves insertion and retrieval of nodes using vertical
     * level as keys.Since there are 2 nested maps,the total complexity becomes
     * o(log2N * log2N).
     * 
     * Space complexity: O(N+N/2) where N is the number of nodes in the binary
     * tree.The map storing nodes based on vertical and level information occupies
     * O(N) space as it stores all N nodes of the tree.The queue for BFS traversal
     * occupies space proportional to the maximum number of nodes at any level,which
     * can be O(N/2) in the worst case for a balanced tree.
     * 
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

    List<List<Integer>> findVector(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
        Queue<Pair> todo = new LinkedList<>();
        todo.offer(new Pair(root, 0, 0));

        while (!todo.isEmpty()) {
            Pair p = todo.poll();
            TreeNode temp = p.node;
            int x = p.vertical;
            int y = p.level;

            nodes.putIfAbsent(x, new TreeMap<>());
            nodes.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodes.get(x).get(y).offer(temp.val);

            if (temp.left != null) {
                todo.offer(new Pair(temp.left, x - 1, y + 1));
            }
            if (temp.right != null) {
                todo.offer(new Pair(temp.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            ans.add(col);

        }
        return ans;

    }

    static class Pair {
        TreeNode node;
        int vertical;
        int level;

        public Pair(TreeNode n, int v, int l) {
            node = n;
            vertical = v;
            level = l;
        }
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int val : level) {
                System.out.print(val + " ");

            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        VectorTraversal obj = new VectorTraversal();
        List<List<Integer>> verticalTraversalss = obj.findVector(root);

        System.out.println("Vertical traversal is: ");
        printResult(verticalTraversalss);
    }
}
