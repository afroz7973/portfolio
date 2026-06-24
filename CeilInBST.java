public class CeilInBST {
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

     int Findceil(TreeNode root,int key){
        int ceil = -1;
        while(root != null){
            if(root.val == key){
                ceil = root.val;
                return ceil;
            }
            if(key > root.val){
                root = root.right;
            }
            else{
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        CeilInBST obj = new CeilInBST();

        int key = 9;

        int result = obj.Findceil(root, key);

        System.out.println("The ceil value of the BST is: " + result);
    }
}
