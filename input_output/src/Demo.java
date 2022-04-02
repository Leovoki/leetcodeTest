import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String s = cin.next();

        System.out.println(s);
        int[] a = new int[n];
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(n-- > 0) {
            list.add(cin.nextInt());
        }
        for(int k = 0; k < a.length; k++) {
            System.out.println(list);
        }
    }
}
