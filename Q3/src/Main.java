public class Main {
    public static void main(String[] args) {
        // Created myMStack object of class MStack
        MStack myMStack = new MStack(4,2);

        // Adding elements to an array holding 2 stacks in 1 array
        myMStack.push('a',1);
        myMStack.push('t',1);
        myMStack.push('n',2);
        myMStack.push('k',2);

        System.out.println("Before popped " + myMStack);

        myMStack.pop(1);
        myMStack.pop(1);

        System.out.println("After popped " + myMStack);
    }
}