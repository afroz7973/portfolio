
import java.util.LinkedList;
import java.util.Queue;



public class MaximumWidthOfBT {

    /*
     * time complexity: O(N) where N is the number of nodes in binary tree.Each node
     * is processed once in level order traversal.
     * space complexity: O(N),IN worst case,the queue holds the nodes of the last level i.e N/2 Nodes.
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

    int getMaxWidth(TreeNode root){
        if(root == null) return 0;
        int maxOfBT = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        // bfs traversal
        while(!q.isEmpty()){
            int size = q.size();
            long minIndex = q.peek().index;
            long first = 0;
            long last = 0;
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                long currIndex = p.index-minIndex;

                if(i == 0) first = currIndex;

                if(i == size-1) last = currIndex;
                if(node.left != null){
                    q.offer(new Pair(node.left, 2*currIndex+1));
                }

                if(node.right != null){
                    q.offer(new Pair(node.right, 2*currIndex+2));
                }
            }
            maxOfBT = Math.max(maxOfBT, (int) (last-first+1));
        }
        return maxOfBT;
    }
    class  Pair{
        TreeNode node;
        long index;

        public Pair(TreeNode n,long  i){
            node = n;
            index = i;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        // root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        MaximumWidthOfBT obj = new MaximumWidthOfBT();
        int result = obj.getMaxWidth(root);
        System.out.print("The width of the binary tree is: " + result);
    }
}
