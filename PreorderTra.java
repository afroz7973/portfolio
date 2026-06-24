
import java.util.ArrayList;
import java.util.List;


/*
recursive approach
time complexity: O(N),we process each node once for traversal
space complexity: O(N),extra space used for storing preorder traversal and recursive stack
 */
public class PreorderTra {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public void PreOrders(Node root,List<Integer> arr){
        if(root == null){
            return;
        }
        arr.add(root.data);
        PreOrders(root.left,arr);
        PreOrders(root.right, arr);
    }

    public List<Integer> PreOrders(Node root){
        List<Integer> arr =new ArrayList<>();
        PreOrders(root,arr);
        return arr;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        PreorderTra obj = new PreorderTra();
        List<Integer> result = obj.PreOrders(root);
        System.out.println("Preorder traversal is: ");
        for(int val:result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
