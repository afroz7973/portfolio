
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PostOrderTra {
    /*
    recursive approach:
     * time complexity: O(N) where N is the number of nodes in binary tree.Each Node
     * is visited once during the traversal
     * space complexity: O(H),where H is the height of binary tree.
     * The space is used by the stack to store nodes during the traversal.
     */
    
     static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
     }

     List<Integer> postOrders(TreeNode root){
        List<Integer> postOrders = new ArrayList<>();
        if(root == null){
            return postOrders;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);

            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            postOrders.add(st2.pop().data);
        }
        return postOrders;
     }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostOrderTra obj = new PostOrderTra();
        List<Integer> result = obj.postOrders(root);
        System.out.println("PostOrder traversal is: ");
        for(int val : result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
