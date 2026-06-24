
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    // node structure of the binary tree
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            data = val;
            left = null;
            right = null;
        }
    }

    class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // solution class containing the traversal function

    public List<List<Integer>> preInOrderTraversal(Node root){
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // if the tree is empty return empty traversal
        if(root == null){
            return new ArrayList<>();
        }
        // stack to maintain nodes and their traversal state
        Stack<Pair<Node,Integer>> st = new Stack<>();
        st.push(new Pair<>(root,1));

        while(!st.empty()){
            Pair<Node,Integer> it = st.pop();
            if(it.getValue() == 1){
                pre.add(it.getKey().data);
                it.setValue(2);
                st.push(it);

                if(it.getKey().left != null){
                    st.push(new Pair<>(it.getKey().left,1));
                }
            }
            else if(it.getValue() == 2){
                in.add(it.getKey().data);
                it.setValue(3);
                st.push(it);
                if(it.getKey().right != null){
                    st.push(new Pair<>(it.getKey().right,1));
                }
            }
            else{
                post.add(it.getKey().data);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }
    // function to print the element of the list
    public void printList(List<Integer> list){
        for(int num : list){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        BinaryTreeTraversal obj = new BinaryTreeTraversal();
        List<List<Integer>> traversals = obj.preInOrderTraversal(root);

        List<Integer> pre = traversals.get(0);
        List<Integer> in = traversals.get(1);
        List<Integer> post = traversals.get(2);

        System.out.println("Preorder traversal is: ");
        obj.printList(pre);

        System.out.println("Inorder traversal is: ");
        obj.printList(in);

        System.out.println("Postorder traversal is: ");
        obj.printList(post);

    }
}
