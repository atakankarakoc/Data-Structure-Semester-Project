import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        HashTable ht = new HashTable();

        //Read values from file and add them into our created hashTable
        BufferedReader read;
        try {
            read = new BufferedReader(new FileReader("C:\\Users\\ataka\\IdeaProjects\\DataStructuresSemesterProject\\Q2\\src\\my_words.txt"));
            String line = read.readLine();
            while (line != null) {
                String[] dictItem = line.split(":");
                ht.put(dictItem[0],dictItem[1]);
                // read next line
                line = read.readLine();
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}