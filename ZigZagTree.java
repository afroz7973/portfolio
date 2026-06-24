
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {

    /*
     * Time complexity: O(N),where N is the number of nodes in the binary tree.Each
     * node is enqueued and dequeued exactly once, hence all the nodes needs to
     * processed and visited.Processing each node takes constant time operations
     * which contributes to overall linera time complexity.
     * space complexity: O(N),where N is the number of nodes in the binary tree.In
     * worst case the queue has to hold the last level of binary tree,the last level
     * could at most hold N/2 nodes hence the space complexity of the queue is
     * proportional to O(N).The resultant vector answer also store the values of
     * nodes level by level and hence contains all the nodes of the tree
     * contributing to O(N) space as well.
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

    List<List<Integer>> zigzagTra(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();

            Integer[] level = new Integer[size];
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                int index = leftToRight ? i:size-1-i;
                level[index] = node.val;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            leftToRight = !leftToRight;
            result.add(Arrays.asList(level));
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

        ZigZagTree obj = new ZigZagTree();
        List<List<Integer>> result = obj.zigzagTra(root);
        System.out.println("The zigzag of the tree is: " + result);
    }
}
