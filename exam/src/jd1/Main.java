package jd1;

import java.util.*;

public class Main {
    public static void main(String[] ags) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<Item> items = new ArrayList<>();
        while(n-- > 0) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            Item item = new Item(a,b,c);
            items.add(item);
        }
        int count = 0;
        for(Item item : items) {
            for(Item other : items) {
                if(other.flag && other.a > item.a && other.b > item.b && other.c > item.c) {
                    item.flag = false;
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}

class Item{
    public int a;
    public int b;
    public int c;
    public  boolean flag = true;
    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
