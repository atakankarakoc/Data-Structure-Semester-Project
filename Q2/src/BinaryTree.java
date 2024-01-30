public class BinaryTree {
    class Node{
        Input value;
        Node left, right;

        //Constructor
        public Node(Input item){
            value = item;
            left = right = null;
        }
    }

    // Root
    Node root;

    // Constructor
    BinaryTree(){
        root = null;
    }

    // This method mainly calls addNode
    void add(Input key){

        root = addNode(root, key);
    }

    // A recursive function to insert a new key in
    Node addNode(Node root, Input key){

        // If the tree is empty, return a new node
        if (root == null){

            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree

        if (key.getKey().compareTo(root.value.getKey()) < 0){

            root.left = addNode(root.left, key);
        }
        else if (key.getKey().compareTo(root.value.getKey()) > 0){

            root.right = addNode(root.right, key);
        }

        return root;
    }
}
