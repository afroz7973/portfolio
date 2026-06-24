public class MaximumPathSum {

    // static class TreeNode{
    // int val;
    // TreeNode left;
    // TreeNode right;

    // public TreeNode(int x){
    // val = x;
    // left = null;
    // right = null;
    // }
    // }
    // public int maxPathSum(TreeNode root){
    // int maxValue[] = new int[1];
    // maxValue[0] = Integer.MIN_VALUE;
    // pathDown(root, maxValue);
    // return maxValue[0];

    // }

    // public int pathDown(TreeNode root,int maxValue[]){
    // if(root == null){
    // return 0;
    // }
    // int left = Math.max(0, pathDown(root.left, maxValue));
    // int right = Math.max(0, pathDown(root.right, maxValue));
    // maxValue[0] = Math.max(maxValue[0], left+right+root.val);
    // return Math.max(left, right)+root.val;

    // }

    /*
     * time complexity: O(N),where N is the number of nodes in binary tree.Each node
     * is processed once in dfs traversal
     * space complexity: O(H) auxiliary stack space, where H is the heigth of binary
     * tree
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

     int maxSum = Integer.MIN_VALUE;
     int maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;

     }
     int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, left+right+root.val);
        return  Math.max(left, right)+root.val;

     }
     
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        MaximumPathSum obj = new MaximumPathSum();
        System.out.println("The maximum sum is: "+obj.maxPathSum(root));
    }
}
