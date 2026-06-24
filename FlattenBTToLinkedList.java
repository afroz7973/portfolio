
public class FlattenBTToLinkedList {
    // brute froce
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.Each node
     * is visited once during the flateening process
     * space complexity: O(log2N) where N is the number of nodes in the binary
     * tree.There are no additional data structure or space is used but the
     * auxiliary stack space is used during recursion.Since the recursion depth can
     * be at most equal to the height of the BT,space complexity is O(H) where H is the height of the BT.In the ideal case,H=log2N and in the worst case H=N skewed tree.
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

    // TreeNode prev = null;
    // void flattenBT(TreeNode root){
    //     if(root == null) return;
    //     flattenBT(root.right);
    //     flattenBT(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }

    // static void printPreorder(TreeNode root){
    //     if(root == null) return;
    //     System.out.print(root.val + " ");
    //     printPreorder(root.left);
    //     printPreorder(root.right);
    // }

    // static void printFlatten(TreeNode root){
    //     if(root == null) return;
    //     System.out.print(root.val + " ");
    //     printFlatten(root.right);

    // }
    
    // Better approach
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.Each node
     * is visited once during the flateening process
     * space complexity: O(log2N) where N is the number of nodes in the binary
     * tree.There are no additional data structure or space is used but the
     * auxiliary stack space is used during recursion.Since the recursion depth can
     * be a
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

    // TreeNode prev = null;
    // void Flatten(TreeNode root){
    //     if(root == null) return;
    //     Deque<TreeNode> st = new ArrayDeque<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode cur = st.pop();
    //         if(cur.right != null){
    //             st.push(cur.right);
    //         }
    //         if(cur.left != null){
    //             st.push(cur.left);
    //         }
    //         if(!st.isEmpty()) cur.right = st.peek();
    //         cur.left = null;
    //     }
    // }

    // static void printPreorder(TreeNode root){
    //     if(root == null) return;
    //     System.out.print(root.val + " ");
    //     printPreorder(root.left);
    //     printPreorder(root.right);
    // }

    // static void printFlatten(TreeNode root){
    //     if(root == null) return;
    //     System.out.print(root.val + " ");
    //     printFlatten(root.right);

    // }

    // optimal approach
    /*
     * time complexity: O(2N) The time complexity is linear,as each node is visited
     * twice.In each step we perform constant time operation,such as moving to the
     * left or right and updating pointer
     * space complexity: O(1) The space complexity is constant, as the algorithm
     * uses only a constant amount of extra space irrespective of the input size.
     * Morris Traversal does not use any additional data structures like stacks or
     * recursion, making it an in-place algorithm. The only space utilised is for a
     * few auxiliary variables, such as pointers to current and in-order predecessor
     * nodes.
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

     void Flatten(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode pre = cur.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
     }

     static void printPreorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
     }

     static void printFlatten(TreeNode root){
        if(root == null) return;
        System.out.println(root.val + " ");
        printFlatten(root.right);

     }
    public static void main(String[] args) {
       TreeNode  root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
       root.left.right = new TreeNode(5);
       root.right.left = new TreeNode(6);
       root.right.right = new TreeNode(7);

       FlattenBTToLinkedList obj = new FlattenBTToLinkedList();
       System.out.println("Binary tree preorder: ");
       printPreorder(root);
       System.out.println();

       obj.Flatten(root);

       System.out.println("Binary tree after flatten: ");
       printFlatten(root);
       System.out.println();
    }
}
