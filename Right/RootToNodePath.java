
import java.util.ArrayList;
import java.util.List;


public class RootToNodePath {

    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.Each node
     * is traversed once during the inorder traversa
     * space complexity: O(N) additional stack space used for recursion ans spade
     * for storing the path
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

    boolean getPath(TreeNode root,List<Integer> arr,int x){
        if(root == null){
            return false;
        }
        arr.add(root.val);
        if(root.val == x){
            return true;
        }
        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)) return true;

        arr.remove(arr.size()-1);
        return false;
    }

    List<Integer> solve(TreeNode root,int x){
        List<Integer> arr = new ArrayList<>();
        if(root == null){
            return arr;
        }
        getPath(root, arr, x);
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        RootToNodePath obj = new RootToNodePath();
        int target = 7;
        List<Integer> path = obj.solve(root, target);

        System.out.print("Path from root to node is " + target +": ");
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i));
            if(i < path.size()-1){
                System.out.print(" -> ");
            }
        }
    }
}
