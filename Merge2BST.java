
import java.util.ArrayList;
import java.util.List;

class Merge2BST {
    // brute force
    /*
     * time complexity: O(n+m)*log(n+m), we traverse both the BST and sort all the
     * element.
     * space complexity:O(m+n),additional space required for storing elements of the
     * two BST.
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

    // void traverse(TreeNode root,List<Integer> ele){
    // if(root == null) return;
    // traverse(root.left, ele);
    // ele.add(root.val);
    // traverse(root.right, ele);
    // }

    // List<Integer> mergeBST(TreeNode root1,TreeNode root2){
    // List<Integer> ele = new ArrayList<>();
    // traverse(root1, ele);
    // traverse(root2, ele);
    // Collections.sort(ele);
    // return ele;
    // }

    // optimal approach
    /*
     * time complexity: O(n+m) we traverse both the BST and merge two sorted lists.
     * space complexity: O(m+n) additional space required for storing elements of
     * two BST.
     */
    void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

    List<Integer> mergeArrays(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> merge = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j))
                merge.add(arr1.get(i++));
            else
                merge.add(arr2.get(j++));
        }
        while (i < arr1.size()) {
            merge.add(arr1.get(i++));
        }
        while (j < arr2.size()) {
            merge.add(arr2.get(j++));
        }
        return merge;

    }

    List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inorderTraversal(root1, arr1);
        inorderTraversal(root2, arr2);

        return mergeArrays(arr1, arr2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(5);

        Merge2BST obj = new Merge2BST();

        List<Integer> result = obj.mergeBST(root1, root2);
        for (int val : result) {
            System.out.print(val + " ");

        }
    }
}