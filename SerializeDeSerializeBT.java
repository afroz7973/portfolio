
import java.util.LinkedList;
import java.util.Queue;


public class SerializeDeSerializeBT {
    /*
     * time complexity: Serialize Function: O(N) Where N is the number of nodes in
     * binary tree.This is bcz the Function performs a level order traversal of the
     * tree,visiting each node once.
     * deserialize function: O(N) Similar to the serialize function it process each
     * node once while reconstructing the tree.
     * 
     * space complexity:
     * serialize: O(N) In worst case the queue can hold all the nodes at the last
     * level of tree
     * deserialize: O(N) The queue is used to store nodes during the reconstruction process and in the worst case it may hold all node at last level.
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
     String Serialize(TreeNode node){
        if(node == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode == null){
                sb.append("#,");
            }
            else{
                sb.append(curNode.val).append(",");
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }
        return sb.toString();
     }
     
     TreeNode deserialize(String data){
        if(data.isEmpty()) return null;

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i= 1;
        while(!q.isEmpty() && i < values.length){
            TreeNode node = q.poll();

            if(!values[i].equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;

            if(!values[i].equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }
        return root;
     }

     void Inorder(TreeNode root){
        if(root == null) return;
        Inorder(root.left);
        System.out.println(root.val + " ");
        Inorder(root.right);
     }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3)  ;
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        SerializeDeSerializeBT obj = new SerializeDeSerializeBT();

        System.out.println("Original tree: ");
        obj.Inorder(root);
        System.out.println();

        String serialize = obj.Serialize(root);
        System.out.println("Serialize: "+serialize);

        TreeNode deserialize = obj.deserialize(serialize);

        System.out.println("Tree After deserialize:");
        obj.Inorder(deserialize);
        System.out.println();


    }
}
