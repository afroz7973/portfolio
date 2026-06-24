
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;





public class TopViewOfBinaryTree {
    /*
     * time complexity:O(N) where N is the number of nodes in the binary tree.Each
     * node is traversed once during the bfs traversal
     * space complexity: O(N/2+N/2) where N is the number of nodes in the binary tree.
     * The main space consuming data structure is the queue used for the bfs traversal.
     * It aquires space proportional to the number of nodes in the level it is exploring in the worst case of a binary tree,the queue have atmost N/2 nodes which is the maximum width.
     * Additionally the map is used to store the top view of the nodes based on their vertical position hence it complexity will be proportional to the greatest width level.
     * In the worst case, it may have N/2 entries well.
     * 
     */
     
    static class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    List<Integer> topView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Map<Integer,Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int line = p.line;

            if(!mpp.containsKey(line)){
                mpp.put(line, node.val);
            }

            if(node.left != null){
                q.add(new Pair(node.left, line-1));
            }

            if(node.right != null){
                q.add(new Pair(node.right, line+1));
            }
        }
        for(int val:mpp.values()){
            ans.add(val);
        }
        return ans;
    }

    static class  Pair{
        TreeNode node;
        int line;

        public Pair(TreeNode n,int l){
            node = n;
            line = l;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TopViewOfBinaryTree obj = new TopViewOfBinaryTree();

        List<Integer> result = obj.topView(root);

        System.out.print("The top view of binary tree is: ");
        for(int val:result){
            System.out.println(val+" ");

        }
    }
}
