public class FloorInBST {
    
    static class TreeNode{
        /*
         * time complexity: O(log2N),where N is the number of nodes in binary tree.The
         * complexity is equivalent to the height of the tree
         * space complexity: O(1),since the algorithm doesnot use any additional space or data structure
         */
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    int FindFloor(TreeNode root,int key){
        int floor = -1;
        while(root != null){
            if(root.val == key){
                floor = root.val;
                return  floor;
            }
            if(key > root.val){
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return  floor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 8;
        FloorInBST obj = new FloorInBST();
        int result = obj.FindFloor(root, key);
        System.out.println("The floor value of the BST is: "+result);
    }
}
