public class RecoverBST {
    /*
     * time complexity: O(N) where N is the number of nodes in BST.In this every
     * node is visited exactly once during inorder traversal
     * space complexity: O(H) where H is the height of nodes in BST.This is bcz recursive call stack stores at most height many nodes
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

    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                middle = last;
            }
            else{
                prev = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    void recoverTree(TreeNode root){
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }

    }

    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.val + " ");
        printInorder(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);

        System.out.print("BST before recovery: ");
        printInorder(root);
        System.out.println();

        RecoverBST obj = new RecoverBST();
        obj.recoverTree(root);
        System.out.print("After Recover BST tree is: ");
        printInorder(root);
    }
}
