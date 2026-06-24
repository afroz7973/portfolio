public class LargestBSTInBS {
    /*
     * time complexity: O(N) where N is the number of nodes in BST.Each node is
     * visited exactly once at each node we do only constant work
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
    class NodeValue{
        public int maxNode, minNode, maxSize;
        public NodeValue(int minNode,int maxNode,int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    private NodeValue largestBSTHelper(TreeNode root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if(left.maxNode < root.val && root.val < right.minNode){
            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                left.maxSize+right.maxSize+1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
     int largetBST(TreeNode root){
        return largestBSTHelper(root).maxSize;

    }
    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.val + " ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        System.out.println("Actual BST is: ");
        printInorder(root);
        System.out.println();

        LargestBSTInBS obj = new LargestBSTInBS();
        int result = obj.largetBST(root);
        System.out.println("The size of BST is: " + result);
        

    }
}

