public class CheckForBalancedTree {

    /*
     * brute froce
     * 
     * time complexity:O(N^2) where N is the number of nodes in binary tree.For each
     * node we calculate the the height of its left and right subtree and height
     * calculation takes O(N) in the worst case,leading to an overall O(N*N)=O(N^2)
     * space complexity: O(H) where H is the height of the tree.This space is used
     * by the recursively call stack of the getHeight function.In worst case H=N and
     * in the best case (balanced tree),H=log N No additional data structures re
     * used,so auxiliary space remains constants
     */
    // static class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;

    //     public TreeNode(int x) {
    //         val = x;
    //         left = null;
    //         right = null;

    //     }
    // }

    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     int leftHeight = getHeight(root.left);
    //     int rightHeight = getHeight(root.right);
    //     if (Math.abs(leftHeight - rightHeight) <= 1 &&
    //             isBalanced(root.left) &&
    //             isBalanced(root.right)) {
    //         return true;
    //     }
    //     return false;
    // }

    //  int getHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftHeight = getHeight(root.left);
    //     int rightHeight = getHeight(root.right);
    //     return Math.max(leftHeight, rightHeight) + 1;
    // }


    // optimal approach

    /*
     * time complexity:O(N) Where N is the number of nodes in binary tree.Each node
     * is traversed exactly once during postorder traversal.
     * space complexity: O(1) since no extra data structure are used that grow with
     * input size. However O(H) auxuliary space is used by the recursion stack,where
     * H is the height oof the tree.
     * in the worst case (balanced tree) h=log2N;INT THE worst case H=N
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

     public boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
     }
     public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight)+1;
     }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        CheckForBalancedTree obj = new CheckForBalancedTree();
        if(obj.isBalanced(root)){
            System.out.println("The tree is balanced..");
        }
        else{
            System.out.println("The tree is not balanced..");
        }
    }
}
