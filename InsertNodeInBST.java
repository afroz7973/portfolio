

public class InsertNodeInBST {
    /*
     * time complexity: O(N)where N is the number of nodes in BST.
     * space complexity: O(1) since we are not using any extra space or data structure
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
    TreeNode insertNode(TreeNode root,int key){
        if(root == null) return new TreeNode(key);
        TreeNode curr = root;

        while(true){
            if(curr.val <= key){
                if(curr.right != null) curr = curr.right;
                else{
                    curr.right = new TreeNode(key);
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new TreeNode(key);
                    break;
                }
            }
        }
        return root;
    }

    static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        int key = 7;
        InsertNodeInBST obj = new InsertNodeInBST();
        inorder(root);
        TreeNode result = obj.insertNode(root, key);
        System.out.print("BST after insertion: ");
        inorder(result);
    }
}
