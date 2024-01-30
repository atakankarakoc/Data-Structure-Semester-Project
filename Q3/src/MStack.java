import java.util.Arrays;
public class MStack {
    private int stacks;    // How many stacks in array
    private int size;      // Size of my array
    private char[] array;  // I hold this stacks
    private int equal;    // For stacks of equal length
    private int[] stackarray; // To keep indexes of heaps in array


    // Constructor
    public MStack(int size, int stacks){

        this.size = size;
        this.stacks = stacks;
        this.array = new char[size];
        equal = (size / stacks);
        stackarray = new int[stacks];
        Dividestacks();
    }

    public void Dividestacks(){

        int splitter = equal;
        for (int i = 0; i< stackarray.length; i++){
            stackarray[i] = splitter;
            splitter+= equal;
        }
    }

    public void push(char ch, int st){

        int givenStack = stackarray[st-1];
        for (int i = givenStack- equal, x = 0; x < equal; x++,i++){
            if (array[i] == 0){
                array[i] = ch;
                return;
            }
        }
        System.out.println("Stack over flow");
    }

    public void pop(int st){


        int stindex = stackarray[st-1];
        for (int i = stindex-1, x = 0; x< equal; x++,i--){
            if (array[i] != 0){
                System.out.println("Poped Element: "+ array[i]);
                array[i] = 0;
                return;
            }
        }
        System.out.println("No more value in stack");
    }

    @Override
    public String toString() {
        return "MStack{" +
                "arr=" + Arrays.toString(array) +
                '}';
    }
}
