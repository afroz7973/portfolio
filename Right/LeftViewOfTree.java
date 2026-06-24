import java.util.ArrayList;
import java.util.List;

public class LeftViewOfTree {
    // optimal approach
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree. In worst
     * case we may visit every node once in binary tree.This happens when the tree
     * is skewed effectively forming a linear structure.Hence the time complexity
     * becomes O(N) .
     * SPPACE complexity: O(H) the complexity depends on the height(H) OF The binary
     * tree due to the recursion stack in depth fist traversal.In a balance binary
     * tree, the height is log2N leading to O(Log N) space.However in worst case a
     * skewed tree the height is N,resulting in O(N) Space
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

    void rightDFS(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;

        if (result.size() == level) {
            result.add(root.val);
            rightDFS(root.right, level + 1, result);
            rightDFS(root.left, level + 1, result);
        }
    }


    void leftDFS(TreeNode root,int level,List<Integer> result){
        if(root == null)
         return;

        if(result.size() == level){
            result.add(root.val);
            leftDFS(root.left, level+1, result);
            leftDFS(root.right, level+1, result);
        }
    }

    List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightDFS(root, 0, result);
        return result;
    }

    List<Integer> leftView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        leftDFS(root, 0, result);
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LeftViewOfTree obj = new LeftViewOfTree();

        List<Integer> right = obj.rightView(root);
        List<Integer> left = obj.leftView(root);
        
        System.out.print("Right view of the binary tree is: ");
        for(int val:right){
            System.out.print(val+" ");
        }
        System.out.print("\nLeft view of the tree is: ");
        for(int val:left){
            System.out.print(val+" ");
        }
    }
}
