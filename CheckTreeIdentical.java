public class CheckTreeIdentical {

    /*
     * time complexity:O(N+M) where N is the number of nodes in first binary tree
     * and M is the number of nodes in second binary tree.Each node
     * is traversed once during traversal.
     * space complexity:O(1) as no additional space or data structures are created
     * that are proportional to the input size of the tree.
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

    // boolean isIdentical(TreeNode p, TreeNode q) {
    // if (p == null || q == null) {
    // return (p == q);
    // }
    // return (p.val == q.val) && isIdentical(p.left, q.left) &&
    // isIdentical(p.right, q.right);

    // }

    // 2nd method
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

    public boolean isIdentical(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (node1.val == node2.val) &&
        isIdentical(node1.left, node2.left) &&
        isIdentical(node1.right, node2.right)
         ;

    }

    public static void main(String[] args) {
        // TreeNode p = new TreeNode(1);
        // p.left = new TreeNode(2);
        // p.right = new TreeNode(3);
        // p.left.left = new TreeNode(4);
        // p.left.right = new TreeNode(5);

        // TreeNode q = new TreeNode(1);
        // q.left = new TreeNode(2);
        // q.right = new TreeNode(3);
        // q.left.left = new TreeNode(4);
        // q.left.right = new TreeNode(5);
        // q.left.left = new TreeNode(6);

        // CheckTreeIdentical obj = new CheckTreeIdentical();
        // if (obj.isIdentical(p, q)) {
        // System.out.println("The binary trees are identical.");
        // } else {
        // System.out.println("The binary tree is not identical.");
        // }

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.left.left = new TreeNode(4);
        node2.left.right = new TreeNode(5);

        CheckTreeIdentical obj = new CheckTreeIdentical();
        if(obj.isIdentical(node1, node2)){
            System.out.println("This tree is identical..");
        }
        else{
            System.out.println("This tree is not identical.");
        }
    }
}
