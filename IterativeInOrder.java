import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {
    /*
     * iterative approach
     * time complexity: O(N),where N is the number of nodes of binary tree.Each node
     * is visited once during the traversal
     * space complexity: O(H),where H is the number of nodes in binary tree.This is the space required for the stack to stores the nodes during the traversal.
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
    
    List<Integer> inorderTra(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> inorderTra = new ArrayList<>();

        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                inorderTra.add(node.val);
                node = node.right;
            }
        }
        return inorderTra;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        IterativeInOrder obj = new IterativeInOrder();
        List<Integer> result = obj.inorderTra(root);

        System.out.println("Inoder traversal is: ");
        for(int val:result){
            System.out.print(val+" ");

        }
        System.out.println();
    }
}
