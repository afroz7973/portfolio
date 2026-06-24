import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrders {

    /*
    Iterative approach:
    
     * time complexity: O(N),where N is the number of nodes in binary tree.Each Node
     * is visited i once during the iterativePreOrder traversal.
     * space complexity:O(H),where H is the height of the binary tree.The space is used by the stack to store the nodes at each level and in worst case it holds the all nodes at a time..
     * 
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

    List<Integer> preorderTra(TreeNode root){
        List<Integer> preorderTra = new ArrayList<>();
        if(root == null){
            return preorderTra;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            root = st.pop();
            preorderTra.add(root.val);

            if(root.right != null){
                st.push(root.right);
            }

            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorderTra;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        IterativePreOrders obj = new IterativePreOrders();
        List<Integer> result = obj.preorderTra(root);
        System.out.println("Preorder traversal is: ");
        for(int val: result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
