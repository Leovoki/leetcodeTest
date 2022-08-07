package MiHaYou.ONE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        String[] str = s.split("<div>");
        System.out.println(str.length-1);

    }
}
