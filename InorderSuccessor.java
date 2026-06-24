import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {
    // brute force
    /*
     * time complexity: O(N+logN) where N is the number of nodes of the BST.O(N)
     * totraverse all nodes and store them in an inorder array and ologN for BST
     * space complexity : O(N) as an array of size N is used to store the inorder traversal of BST
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

    TreeNode inorderSuccessor(TreeNode root,TreeNode p){
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int idx = binarySearch(inorder, p.val);
        if(idx == inorder.size()-1 || idx == -1){
            return null;
        }
        return new TreeNode(inorder.get(idx+1));
    }

    void  inorderTraversal(TreeNode root,List<Integer> inorder){
        if(root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);

    }

    int binarySearch(List<Integer> arr,int target){
        int left=0, right = arr.size()-1;
        while(left <= right){
            int mid=left+(right-left)/2;
            if(arr.get(mid) == target) return mid;
            else if (arr.get(mid) < target) left=mid+1;
            else right = mid-1;
        }
        return left == arr.size() ? -1:left;
    }

    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);

    }

    // optimal approach
    /*
     * time complexity: O(H) where H is the height of the BST,as we are trversing
     * along the height of the tree
     * space complexity: O(1) as no additiona data structure and memory allocation is done during the traversaland algorithm
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

    // TreeNode InorderSuccessor(TreeNode root,TreeNode p){
    //     TreeNode successor = null;
    //     while(root != null){
    //         if(p.val >=root.val){
    //             root = root.right;
    //         }
    //         else{
    //             successor = root;
    //             root = root.left;
    //         }
    //     }
    //     return successor;
    // }

    // static void printInorder(TreeNode root){
    //     if(root == null) return;
    //     printInorder(root.left);
    //     System.out.print(root.val + " ");
    //     printInorder(root.right);

    // }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.print("BST is: ");
        printInorder(root);
        System.out.println();
        TreeNode p = root.left.right;
        
        InorderSuccessor obj = new InorderSuccessor();
        TreeNode result = obj.inorderSuccessor(root, p);
        if(result != null){
            System.out.print("Inorder successor of " + p.val + " is: " + result.val);
        }
        else{
            System.out.print("Inorder successor of " + p.val + "does not exist");
        }
    }
}
