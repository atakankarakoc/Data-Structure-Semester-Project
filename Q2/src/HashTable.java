public class HashTable {
    private BinaryTree[] input = new BinaryTree[10];
    private int hash(String key){
        int hash = 0;
        for (var ch : key.toCharArray()){
            hash += ch;
        }
        return hash % input.length;
    }
    public void put(String key, String value){
        var index = hash(key);
        if (input[index] == null) {
            input[index] = new BinaryTree(); //LinkedList<>();
        }

        var bucket = input[index]; // type of bucket is Input in LinkedList
        bucket.add(new Input(key, value));
    }


}
