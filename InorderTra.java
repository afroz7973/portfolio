
import java.util.ArrayList;
import java.util.List;



public class InorderTra {

    // Recursive Approach
    /*
     * time complexity: O(N),where N is the number of nodes in the binary tree.Each
     * node is visisted exactly once during traversal.
     * space complexity: O(N),where N is the number of nodes int the binary tree.
     * The space is used for recursion stack and the vector to store the inorder traversal
     * 
     */
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            data = val;
            left = null;
            right =null;
        }
    }

    private void  inOrders(TreeNode root,List<Integer> arr){
        if(root == null){
            return;
        }
        inOrders(root.left, arr);
        arr.add(root.data);
        inOrders(root.right, arr);
    }

    public List<Integer> inOrders(TreeNode root){
        List<Integer> arr = new ArrayList<>();
        inOrders(root,arr);
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        InorderTra obj = new InorderTra();
        List<Integer> result = obj.inOrders(root);

        System.out.println("Inorder traversal are: ");
        for(int val : result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
