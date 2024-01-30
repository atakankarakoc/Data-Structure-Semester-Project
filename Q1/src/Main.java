public class Main {
    public static void main(String[] args) {

        BTree tree = new BTree();

        int [] sortArray = {105,88,990,3,55,10};

        System.out.println("Unsorted:");

        for(int i = 0; i< sortArray.length; i++){
            System.out.print(sortArray[i] + " ");
        }
        System.out.println();
        tree.sort(sortArray);
        System.out.println("Sorted: ");
        for(int i = 0; i< sortArray.length; i++){
            System.out.print(sortArray[i] + " ");
        }
        System.out.println("");

    }
}