
import java.util.Stack;

public class TwoSumInBST {
    // brute force
    /*
     * time complexity: O(N+N) where N is the number of nodes in BST.To create the
     * array that will store the inorder sequence, we have to traverse the entire
     * BST,hence O(N) and to apply two pointer approach and get the pair equal to
     * sum again requires O(N) hence O(N+N)~O(2N)~O(N)
     * space complexity: O(N) where N is the number of nodes in BST,as we have to
     * store all the nodes in an additional data structure array.The two pointer
     * approach does not use any additional space hence sc is O(N)
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

    // boolean findTarget(TreeNode root,int k){
    //     List<Integer> inorder = new ArrayList<>();
    //     inorderTraversal(root, inorder);
    //     int left=0;
    //     int right=inorder.size()-1;

    //     while(left < right){
    //         int sum = inorder.get(left)+inorder.get(right);
    //         if(sum == k){
    //             return true;
    //         }
    //         else if(sum < k){
    //             left++;
    //         }
    //         else{
    //             right--;
    //         }
    //     }
    //     return false;
    // }

    // void inorderTraversal(TreeNode root,List<Integer> inorder){
    //     if(root == null) return;
    //     inorderTraversal(root.left, inorder);
    //     inorder.add(root.val);
    //     inorderTraversal(root.right, inorder);

    // }

    // static void printInorder(TreeNode root){
    //     if(root == null) return;
    //     printInorder(root.left);
    //     System.out.print(root.val + " ");
    //     printInorder(root.right);

    // }

    // optimal approach
    /*
     * time complexity: O(N) where N is the number of nodes in BST as we have to
     * traverse all the nodes using the i and j pointers to find the pair with sum
     * 'k'
     * space complexity: O(H) where H is the height of the BST as the BSTIterator class uses a stack to store the nodes.At maximum the size such a stack will be equal to the height of BT.
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

    Stack<TreeNode> stack;
    private boolean reverse;

    class BSTIterator{

        public BSTIterator(TreeNode root,boolean  isReverse) {
            stack = new Stack<>();
            reverse = isReverse;
            pushAll(root);
        }
        boolean hasNext(){
            return !stack.isEmpty();
        }
        int next(){
            TreeNode tempNode = stack.pop();
            if(!reverse){
                pushAll(tempNode.right);
            }
            else{
                pushAll(tempNode.left);
            }
            return tempNode.val;
        }
    }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if(reverse){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
    }

    boolean findTarget(TreeNode root,int k){
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i+j == k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }

    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        System.out.print("Tree Initialized: ");
        printInorder(root);
        System.out.println();

        TwoSumInBST obj = new TwoSumInBST();
        int target = 220;
        boolean result = obj.findTarget(root, target);

        if(result){
            System.out.println("Pair with sum " + target + " exists.");
        }
        else{
            System.out.println("Pair with sum " + target + " does not exist.");
        }
    }
}
