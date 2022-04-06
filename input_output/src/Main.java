import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<String> list = new ArrayList<>();
        while(n-->0) {
            list.add(cin.next());
        }
        Collections.sort(list);
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size; i++) {
            stringBuilder.append(list.get(i));
            if(i == size-1) {
                continue;
            } else {
                stringBuilder.append(' ');
            }
        }
        System.out.println(new String(stringBuilder));
    }
}