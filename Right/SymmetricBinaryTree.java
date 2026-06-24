public class SymmetricBinaryTree {
    /*
     * Time complexity: O(N) where N is the number of nodes in binary tree.This
     * complexity arises from visiting each node exactly once during the traversal
     * and the function compares nodes in a symmetric manner.
     * space complexity: O(1) as no additional data structures or memory is
     * allocated.
     * 
     */
    // static class TreeNode {
    // int val;
    // TreeNode left;
    // TreeNode right;

    // public TreeNode(int x) {
    // val = x;
    // left = null;
    // right = null;
    // }
    // }

    // boolean isSymmetric(TreeNode root) {
    // return root == null || isSymmetricHelp(root.left, root.right);
    // }

    // private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
    // if (left == null || right == null) {
    // return left == right;
    // }
    // if (left.val != right.val)
    // return false;

    // return isSymmetricHelp(left.left, right.right) &&
    // isSymmetricHelp(left.right, right.left);
    // }

    
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

    boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        return (left.val == right.val) && isSymmetric(left.right, right.left) && isSymmetric(left.right, right.left);
    }

    boolean isSymmetricUtil(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        SymmetricBinaryTree obj = new SymmetricBinaryTree();

        boolean result = obj.isSymmetricUtil(root);
        if(result){
            System.out.println("The tree is symmetric..");
        }
        else{
            System.out.println("The tree is not symmetric..");
        }
    }
}
