public class Graph {
    public final int  [][] edges;
    private final char [] vertices;

    //Constructor
    public Graph(int v){

        this.edges = new int[v][v];
        this.vertices    = new char[v];

        for(int i = 0; i < v ; i++)
            this.vertices[i] = (char)('A' + i);
    }
    //A method to add edges between 2 nodes
    public void addEdge(int v1,int v2, int w){

        if(v1 >= this.vertices.length || v2 >= this.vertices.length)
            System.out.println("V1 or V2 can't bigger than Vertices's lenght");
        else{
            this.edges[v1][v2] = w;
            this.edges[v2][v1] = w;
        }

    }
    //A matrix table method that shows the distances between nodes
    public void printMatrix(){

        System.out.print("  ");

        for(char i : this.vertices)
            System.out.print(i + " ");

        System.out.println();


        for (int i = 0 ; i < this.edges.length; i++){
            System.out.print(this.vertices[i] + "|");
            for (int j = 0; j < this.edges.length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
