


public class DiameterOfBinaryTree {
    // brute force
    /*
     * time complexity: O(N*N) where N is the number of nodes in the binary tree.
     * spae complexity:O(1),as no additional data structure is used to solve this problem
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

    // int diameter = 0;

    // public int calculateHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftHeight = calculateHeight(root.left);
    //     int rightHeight = calculateHeight(root.right);
    //     diameter = Math.max(diameter, leftHeight + rightHeight);
    //     return 1 + Math.max(leftHeight, rightHeight);
    // }

    // int diaOfBinaryTree(TreeNode root) {
    //     calculateHeight(root);
    //     return diameter;

    // }

    // optimal approach
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.This
     * complexity arises from visiting each node exacty once during the postorder
     * traversal.
     * space complexity: O(1) as no additional space or data structure is created that is proportional to the input size of the tree.
     */
    // static class TreeNode{
    //     int val;
    //     TreeNode left;
    //     TreeNode right;

    //     public TreeNode(int x){
    //         val = x;
    //         left = null;
    //         right = null;
    //     }
    // }

    // public int diaOfBinaryTree(TreeNode root){
    //     int[] diameter = new int[1];
    //     diameter[0] = 0;
    //     height(root, diameter);
    //     return diameter[0];
    // }
    // public int height(TreeNode root,int[] diameter){
    //     if(root == null){
    //         return 0;
    //     }
    //     int[] lh = new int[1];
    //     int[] rh = new int[1];
    //     lh[0] = height(root.left, diameter);
    //     rh[0] = height(root.right, diameter);
    //     diameter[0] = Math.max(diameter[0], lh[0]+rh[0]);
    //     return 1+Math.max(lh[0],rh[0]);
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
    public int diaOfBinaryTree(TreeNode root){
        int[] diameter = new int[1];
        diameter[0] = 0;
        height(root, diameter);
        return diameter[0];
    }

    public int height(TreeNode root,int[] diameter){
        if(root == null){
            return 0;
        }
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(root.left, diameter);
        rh[0] = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh[0]+rh[0]);
        return 1+Math.max(lh[0],rh[0]);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        int result = obj.diaOfBinaryTree(root);
        System.out.println("The diameter of the binary tree is: "+result);

    }
}
