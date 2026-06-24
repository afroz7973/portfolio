public class CountCompleteTreeNode {
    // brute force
    /*
     * time complexity: O(N) where N is the number of nodes in the binary tree.Each
     * node is visited exactly once.
     * 
     * space complexity: O(N) where N is the number of nodes in binary tree.This is
     * bcz recursive stack uses an auxiliary space which can potentially hold all
     * nodes in the tree when dealing with a skewed tree,consuming space
     * proportional to the number of nodes.In the average case or for a balanced
     * tree,the maximum number of nodes that could be in the stack at any given time
     * would be roughly the height of tree is O(N)
     * 
     */

//     static class TreeNode{
//         int val;
//         TreeNode left;
//         TreeNode right;

//         public TreeNode(int x){
//             val = x;
//             left = null;
//             right = null;
//         }
//     }

//   void inorder(TreeNode root,int[] count){
//     if(root == null) return;;
//     count[0]++;
//     inorder(root.left, count);
//     inorder(root.right, count);
//   }

//   int countNodes(TreeNode root){
//     if(root == null){
//         return 0;
//     }
//     int[] count = new int[1];
//     inorder(root, count);
//     return count[0];
//   }

// optimal approach
/*
 * time complexity: O(logN)*(logN) where N is the number of nodes in the binary
 * tree.The calculation of leftHeight and rightHeight takes O(logN) time.In
 * worst case,when encountering the second case (leftHeight != rightHeight),the
 * recursive calls are made at most logN times .
 * 
 * space complexity: O(H)~O(N) where N is the number of nodes in the binary
 * tree.The SC is determined by the maximum depth of the recursion stack,which
 * is equal to the height of the binary tree.Since the given binary tree is a
 * complete binary tree,the height will always be logN.Therefore the space
 * complexity O(logN)
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

 int countNodes(TreeNode root){
    if(root == null){
        return 0;
    }
    int lh = getHeightleft(root);
    int rh = getHeightright(root);

    if(lh == rh){
        return (1<<lh)-1;
    }
    return 1+countNodes(root.left)+countNodes(root.right);

 }

 int getHeightleft(TreeNode node ){
    int height = 0;
    while(node != null){
        height++;
        node = node.left;
    }
    return height;
 }

 int getHeightright(TreeNode node){
    int height = 0;
    while(node != null){
        height++;
        node = node.right;
    }
    return height;
 }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        CountCompleteTreeNode obj = new CountCompleteTreeNode();
        int result = obj.countNodes(root);
        System.out.println("Total nodes of a complete binary tree is: "+result);
    }
}
