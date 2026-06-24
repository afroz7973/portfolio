
import java.util.ArrayList;
import java.util.List;



public class KthSmallestEleInBST {
    // brute force
    /*
     * time complexity: O(N) where N is the number of nodes in the BST.Bcz the code
     * performs an inorder traversal of BST,which requires O(N) time.
     * space complexity: O(N) since the code stores all the nodes values in list.
     */

    // static class TreeNode{
    //     int val;
    //     TreeNode left;
    //     TreeNode right;

    //     public TreeNode(int x){
    //         val = x;
    //         left = null;
    //         right = null;
    //     }
    // }

    // void inorder(TreeNode node,List<Integer> values){
    //     if(node != null){
    //         inorder(node.left, values);
    //         values.add(node.val);
    //         inorder(node.right, values);
    //     }
    // }
    // List<Integer> kthSmallest(TreeNode node,int k){
    //     List<Integer> values = new ArrayList<>();
    //     inorder(node, values);

    //     int small = values.get(k-1);
    //     int larger = values.get(values.size()-k);

    //     List<Integer> result = new ArrayList<>();
    //     result.add(small);
    //     result.add(larger);
    //     return result;
    // }

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

    int kthSmallest(TreeNode root,int k){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        // return list.get(k-1);  for smallest node
        return list.get(list.size()-k); 
    }

    static void inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestEleInBST obj = new KthSmallestEleInBST();
        int k = 1;
        int result = obj.kthSmallest(root, k);
        // System.out.println("The smallest element is: "+result);
        System.out.println("The largest element is: "+result);

    }
}
