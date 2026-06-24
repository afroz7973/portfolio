import java.util.List;

import org.w3c.dom.Node;

public class PreInPostOrderTra {

    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sol = new Solution();
        List<List<Integer>> res = sol.preInPostTraversal(root);

        System.out.println("Preorder: " + res.get(0));
        System.out.println("Inorder: " + res.get(1));
        System.out.println("Postorder: " + res.get(2));
    }
}
