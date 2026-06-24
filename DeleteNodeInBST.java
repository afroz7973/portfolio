public class DeleteNodeInBST {
    /*
     * time complexity: Best/average: O(LogN) for balanced BST
     * Worst case: O(N) for skewed tree
     * space complexity : O(1) iterative delete
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

     TreeNode deleteNode(TreeNode root,int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
     }

     TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
     }

     TreeNode findLastRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
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
        root.right.right = new TreeNode(14);

        int key = 9;
        DeleteNodeInBST obj = new DeleteNodeInBST();
        System.out.print("Original tree: ");
        inorder(root);

        TreeNode result = obj.deleteNode(root, key);
        System.out.println("\nBST after deletion: ");
        inorder(result);
    }
}
