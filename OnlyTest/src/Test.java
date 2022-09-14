import java.util.*;

public class Test {
    public static void main(String[] args) {
        Collection<String> col = Arrays.asList("1","2");
        System.out.print(col instanceof LinkedList);
        System.out.print(col instanceof ArrayList);
        System.out.print(col instanceof List);
    }
}
