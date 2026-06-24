
import java.util.HashMap;

public class ConstructBTFromPostandIn {

    /*
     * time complexity: O(N) where n is the number of nodes in binary tree.Each node
     * is visited once during the traversal
     * space complexity: O(N) where N is the number of nodes in binary tree.This complexity is due to hashMap and recusion stack
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    TreeNode buildTree(int[] inorder,int[] postoder){
        if(inorder.length != postoder.length) return null;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            hashMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postoder, 0, postoder.length-1, hashMap);

    }

    TreeNode build(int[] inorder,int is,int ie,int[] postoder,int ps,int pe,HashMap<Integer,Integer> hashMap){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postoder[pe]);
        int inRoot = hashMap.get(postoder[pe]);
        int numsLeft = inRoot-is;
        
        root.left = build(inorder, is, inRoot-1, postoder, ps, ps+numsLeft-1, hashMap);
        root.right = build(inorder, inRoot+1, ie, postoder, ps+numsLeft, pe-1, hashMap);
        return root;

    }
    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.val + " ");
        printInorder(root.right);

    }

    public static void main(String[] args) {
        int[] inorder = { 40, 20, 50, 10, 60, 30 };
        int[] postorder = { 40, 50, 20, 60, 30, 10 };
        ConstructBTFromPostandIn obj = new ConstructBTFromPostandIn();
        TreeNode result = obj.buildTree(inorder, postorder);

        System.out.print("unique binary tree of postoder is: ");
        printInorder(result);
    }
}
