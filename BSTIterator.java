
import java.util.Stack;

public class BSTIterator {
    /*
     * time complexity: O(1) next() → amortized O(1)
     * hasNext() → O(1)
     * space complexity: O(H) where H is the height of BST
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

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root){
            pushAll(root);

        }
        public int next(){
            TreeNode tempNode = stack.pop();
            pushAll(tempNode.right);
            return tempNode.val;
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }
        private void  pushAll(TreeNode node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);
        
        while(obj.hasNext()){
            System.out.println(obj.next());
        }
    }
}
