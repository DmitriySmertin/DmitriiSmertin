import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word {


    public static void main(String[] args) {

        Set<String> fruit = new HashSet<>();
        fruit.add("Apple");
        fruit.add("Peach");
        fruit.add("Apple");
        fruit.add("Peach");
        fruit.add("Orange");
        fruit.add("Marsian Fruit");
        printUnicFruct(fruit);

    }

    public static void printUnicFruct(Set<String> frukt) {

        for (String a : frukt) {
            System.out.println(a);
        }
    }

}
