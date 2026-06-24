public class LCAInBST {
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
    TreeNode lowestCommonAncestor(TreeNode root,TreeNode  p,TreeNode q){
        if(root == null) return null;
        int curr = root.val;
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);  

        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        LCAInBST obj = new LCAInBST();

        TreeNode result = obj.lowestCommonAncestor(root, p, q);
        System.out.println("The LCA of BST is: "+result.val);
    }
}
