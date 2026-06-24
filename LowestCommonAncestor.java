public class LowestCommonAncestor {
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.In worst
     * case we need to traverse all nodes to find LCA
     * space complexity: O(H) where H is the height of the nodes in binary tree.This
     * is due to recursive stack space used during the traversal.In the worst case,
     * for a skewed tree H can be equal to N, but for a balanced tree,H will be
     * log(N)
     */
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    TreeNode getCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = getCommonAncestor(root.left, p, q);
        TreeNode right = getCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return right;
        return root;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LowestCommonAncestor obj = new LowestCommonAncestor();

        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode result = obj.getCommonAncestor(root, p, q);
        System.out.println("The lowest common ancestor is: "+result.val);
    }
}
