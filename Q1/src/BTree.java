import java.util.ArrayList;
import java.util.function.Consumer;

public class BTree{
    private Node root;

    private final int T = 5;

    // Node creation
    public class Node {
        int n;
        int[] key = new int[2 * T - 1];
        Node[] child = new Node[2 * T];
        boolean leaf = true;
    }

    public BTree() {

        root = new Node();
        root.n = 0;
        root.leaf = true;
    }
    // Splitting the node
    private void Split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.key[j] = y.key[j + T];
        }
        //If y-node or z-node has childs
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;

        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        //move median to parent
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }

    // Inserting a value
    public void Insert(int key) {

        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            Split(s, 0, r);
            insertValue(s, key);
        } else {
            insertValue(r, key);
        }
    }

    // Insert the node
    private void insertValue(Node x, int k) {

        //if node is leaf...
        if (x.leaf) {
            int i;
            //sliding keys for inserted nodes...
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            int i;
            //which child key to insert
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {

            }
            i++;
            Node tmp = x.child[i];
            //is child on limit ?
            if (tmp.n == 2 * T - 1) {
                Split(x, i, tmp);
                //which child key to insert
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertValue(x.child[i], k);
        }

    }


    public void inOrderTraversal(Consumer<Integer> callback) {
        inOrderTraversal(root, callback);
    }

    private void inOrderTraversal(Node node, Consumer<Integer> callback) {
        if (node == null) return;

        // Recursively traverse the left subtree
        inOrderTraversal(node.child[0], callback);

        // Visit all keys in the node
        for (int i = 0; i < node.n; i++) {
            callback.accept(node.key[i]);
            // Recursively traverse the right subtree for the next key
            inOrderTraversal(node.child[i + 1], callback);
        }
    }


    public void sort(int[] array) {
        // Create a B-tree with the array elements as keys
        BTree tree = new BTree();
        for (int i : array) {
            tree.Insert(i);
        }

        // Traverse the B-tree in order and add the keys to a list
        ArrayList<Integer> sorted = new ArrayList<>();
        tree.inOrderTraversal(sorted::add);

        // Copy the sorted elements back into the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = sorted.get(i);
        }
    }

}
