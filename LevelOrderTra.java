
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrderTra {

    /*
     * time complexity: O(N),where N is the number of nodes in binary tree.Each node
     * is visited once during the level order traversal
     * space complexity:O(N),where N is thne number of nodes in binary tree.The space is used by queue and int worst case it can hold all nodes as last level.
     */
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null){
            return levelOrder;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                level.add(node.data);

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LevelOrderTra obj = new LevelOrderTra();
        List<List<Integer>> result = obj.levelOrder(root);
        System.out.println("LevelOrder traversal is: ");
        for(List<Integer> level:result){
            System.out.println(level);
        }
    }
}
