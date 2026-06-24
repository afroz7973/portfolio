
import java.util.ArrayList;
import java.util.List;



public class MorrisPreOrderOfBT {
    /*
     * time complexity: O(2N) where N is the number of nodes in the binary tree.The
     * time complexity is linear,as each node is visited at most twice(one for
     * establishing the temporary link and once for reveting it.)
     * space complexity: O(1), space complexity is constant,as the algorithm uses only a constant amount of extra space irrespective of the input size
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

    List<Integer> getPreorder(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisPreOrderOfBT obj = new MorrisPreOrderOfBT();
        List<Integer> preorder = obj.getPreorder(root);
        System.out.print("Morris preorder of binary tree is: ");

        for(int i = 0; i < preorder.size(); i++){
            System.out.print(preorder.get(i) + " ");
        }
        System.out.println();
    }
}
