
import java.util.LinkedList;
import java.util.Queue;





public class MaxDepthInBinaryTree {

    /*
     * level order traversal
     * time complexity:O(N)where N is the number of nodes in binary tree.Each node
     * is processed once in level order traversal
     * space complexity:O(N),in worst case a maximum of N/2 nodes can be present in the queue
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

      int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode front = q.poll();

                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }  
            level++;
        }
        return level;
        
     }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MaxDepthInBinaryTree obj = new MaxDepthInBinaryTree();
        int result = obj.maxDepth(root);
        System.out.println("Maximum depth of biary tree is: "+result);
    }
}
