public class SearchInBST {
    static class TreeNode {
        /*
         * Time complexity: O(log2N) where N is the number of nodes in the binary search
         * tree.Each step eliminate half of the tree,just like binary search.However,in
         * the worst case,it could be O(N)
         * space complexity: O(1),Iterative solution used constant space as no recursion stack is involved.
         */
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    TreeNode searchBST(TreeNode root, int target) {
        while (root != null && root.val != target) {
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(20);

        int target = 70;

        SearchInBST obj = new SearchInBST();
        TreeNode result = obj.searchBST(root, target);
        if(result != null){
            System.out.println("Node found!" + result.val);
        }
        else{
            System.out.println("Node not found!");
        }
    }
}
