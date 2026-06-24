
import java.util.ArrayList;
import java.util.List;

/*

time complexity: O(N) where N is the number of nodes in binary tree
space complexity: O(N) where N is the number of nodes in binary tree to store the boundary nodes of the bianry tree.
O(H) or O(log2N) Recursive stack space while traversing the tree.Inworst case scenario the tree is skewed and the auxiliary recursion stack space would be stacked up to the maximum depth of the tree,resultin in an O(N) auxiliary space.

 */

public class BoundaryTraversal {
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

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;

    }

    void leftBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) {
                res.add(cur.val);

            }
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }

        }
    }

    void righBoundary(TreeNode root, List<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) {
                temp.add(cur.val);
            }
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }

    }

    void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);

        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    List<Integer> printBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        leftBoundary(root, res);
        addLeaves(root, res);
        righBoundary(root, res);
        return res;

    }

    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BoundaryTraversal obj = new BoundaryTraversal();
        List<Integer> result = obj.printBoundary(root);
        System.out.print("Boundary Treaversal: ");
        obj.printResult(result);
    }
}
