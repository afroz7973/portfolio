public class CheckIfBST {

    /*
     * time complexity: O(N) where N is the number of nodes in the BST.
     * space complexity: O(H) where H is the height of nodes in BST.
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

     boolean isValidBST(TreeNode root){
        return isValidBST(root,Long.MIN_VALUE,Long.MIN_VALUE);
     }

     boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left,minVal,root.val) && isValidBST(root.right,maxVal,root.val);

     }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);

        CheckIfBST obj = new CheckIfBST();
        boolean result = obj.isValidBST(root);
        // if (result){
        //     System.out.println("This is BST");
        // }
        // else{

        //     System.out.println("This is not a BST");
        // }
        System.out.println(result ? "This is BST" : "This is not a BST");
    }
}
