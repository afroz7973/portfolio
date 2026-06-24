
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BottomViewOfBinary {
    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.Each node
     * is traversed once during the BFS traversal
     * Space complexity: O(N/2+N/2) where N represents the number of nodes in the binary tree
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

    List<Integer> bottomView(TreeNode root){
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

            mpp.put(line, node.val);

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
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        BottomViewOfBinary obj = new BottomViewOfBinary();
        List<Integer> result = obj.bottomView(root);
        System.out.print("Bottom view of the binary tree is:");
        for(int val:result){
            System.out.println(val+" ");

        }
    }
}
