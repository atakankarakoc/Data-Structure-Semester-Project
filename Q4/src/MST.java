public class MST {
    // At an infinite distance since
    // the vertices are not connected at the beginning
    private static final int DISTANCE = 100000;

    // A method that returns the shortest edge relative to the nearest node
    static int primsMST(int key[], boolean visited[]){

        int min = DISTANCE;
        int minIndex = 0;

        for (int i = 0; i < 8; i++) {
            if (visited[i] == false && key[i] < min){ // conditions
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;

    }
    static void prims(int edges[][]){

        int key[] = new int[8];             // the node we are on
        int parent[] = new int[8];          // parent of our node
        boolean visited[] = new boolean[8]; // An Array holding visited nodes

        for (int i = 0; i < 8; i++) {

            visited[i] = false; // False because not all nodes are visited
            key[i] = DISTANCE;  // The distance is infinite because
            // the nodes are not connected

        }
        key[0] = 0;     // initial state value
        parent[0] = -1; // initial state value

        for (int j = 0; j < 8; j++) { // loop to create mst by traversing all graphs
            int enkisa = primsMST(key,visited);
            visited[enkisa] = true; // The node is marked as visited

            for (int k = 0; k < 8; k++) { // Search all nodes in MST
                if (edges[enkisa][k] != 0 && visited[k] == false && edges[enkisa][k] < key[k]) { // Conditions
                    key[k] = edges[enkisa][k]; //update
                    parent[k] = enkisa;
                }
            }
        }

        printMST(edges,parent);
    }
    // Method to print nodes and edges to the screen
    static void printMST(int edges[][],int parent[]){
        int mintew=0;
        for (int i = 1; i < 8; i++) {
            System.out.printf("\n%d - %d --> %d \n", parent[i],i,edges[i][parent[i]]);
            mintew+=edges[i][parent[i]];
        }
        // Minimum Total Edge Weight
        System.out.println("\nMinimum Total Edge Weight: " +mintew);
    }

    public static void main(String[] args) {
        // mygraph referencing the Graph class has been created
        // Parameter value is 8 because I have 8 nodes(vertex)
        Graph mygraph = new Graph(8);

        // Creating edges
        mygraph.addEdge(0,1,12);
        mygraph.addEdge(0,2,17);
        mygraph.addEdge(0,3,20);
        mygraph.addEdge(1,2,21);
        mygraph.addEdge(1,7,19);
        mygraph.addEdge(2,3,4);
        mygraph.addEdge(2,6,6);
        mygraph.addEdge(2,4,88);
        mygraph.addEdge(3,5,15);
        mygraph.addEdge(3,6,13);
        mygraph.addEdge(4,5,30);
        mygraph.addEdge(4,6,37);
        mygraph.addEdge(4,7,19);
        mygraph.addEdge(5,6,44);

        mygraph.printMatrix();

        prims(mygraph.edges);
    }
}
