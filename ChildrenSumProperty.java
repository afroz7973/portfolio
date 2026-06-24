public class ChildrenSumProperty {
    /*
     * time complexity: O(N) where N is the number of nodes in the binary tree.This
     * is because each node is traversed exactly once,performing constant-time
     * operation at each node.
     * space complexity: O(N) where N is the number of nodes in the binary tree.
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

     void changeTree(TreeNode root){
        if(root == null) return;
        int child = 0;
        if(root.left != null){
            child += root.left.val;
        }

        if(root.right != null){
            child += root.right.val;
        }
        if(child >= root.val){
            root.val = child;
        }
        else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if(root.left != null){
            tot += root.left.val;
        }

        if(root.right != null){
            tot += root.right.val;
        }

        if(root.left != null || root.right != null){
            root.val = tot;

        }
     }

     class treeTraversal{
        static  void  inorderTraversal(TreeNode root){
            if(root == null) return;

            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
     }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ChildrenSumProperty obj = new ChildrenSumProperty();
        System.out.print("Binary tree before modification: ");
        treeTraversal.inorderTraversal(root);
        System.out.println();

        obj.changeTree(root);

        System.out.print("Binary tree after modification: ");
        treeTraversal.inorderTraversal(root);
        System.out.println();

        
    }
}
