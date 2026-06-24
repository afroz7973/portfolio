public class BSTFromPreorder {
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

    TreeNode bstFromPre(int[] A){
        return bstFromPre(A,Integer.MAX_VALUE,new int[]{0});
    }
    
    TreeNode bstFromPre(int[] A,int bound,int[] i){
        if(i[0] == A.length || A[i[0]] > bound) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPre(A, root.val, i);
        root.right = bstFromPre(A, bound, i);
        return root;
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        int[] preorder = {10,4, 3, 6, 15, 18, 20};

        BSTFromPreorder obj = new BSTFromPreorder();
        TreeNode result = obj.bstFromPre(preorder);
        
        System.out.print("Inorder traversal");
        obj.inorder(result);
    }
}
