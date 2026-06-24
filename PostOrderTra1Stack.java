
import java.util.ArrayList;
import java.util.List;

public class PostOrderTra1Stack {

    /*
     * recursive postorder traversal
     * time complexity:O(N),where N is the number of nodes in the binary tree.Each
     * node is visited once during the traversal
     * space complexity: O(N),Extra space is used for storing the postorder traversal and recursion stack space
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

    public void postOrderTra(TreeNode root,List<Integer> result){
        if(root == null)
            return;
        postOrderTra(root.left,result);
        postOrderTra(root.right, result);
        result.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostOrderTra1Stack obj = new PostOrderTra1Stack();
        List<Integer> result = new ArrayList<>();
        obj.postOrderTra(root, result);

        System.out.println("Postorder traversal is: ");
        for(int val:result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
