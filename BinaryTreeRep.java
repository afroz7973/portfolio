public class BinaryTreeRep {

    class Node {
        int data;
        Node left, right;

        public Node(int key) {
            data = key;
        }
    }

    Node root;

    // insert method
    public Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // inorder traversal
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        BinaryTreeRep tree = new BinaryTreeRep();

        tree.root = tree.insert(tree.root, 10);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 7);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
    }
}
