package String_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String[]  str = cin.nextLine().split(",");
            Arrays.sort(str);
            System.out.print(String.join(",",str));
            System.out.println();

        }
    }
}
