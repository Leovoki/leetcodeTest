package XHS.ONE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//大臣人数
        int m = cin.nextInt();//重要数量
        int id = cin.nextInt();
        if(n == 1) {
            System.out.println(1);
            return;
        }
        int i = 1;
        List<People> list = new ArrayList<>();
        while(i <= n) {
            Double important = 0.00;
            for(int j = 0; j < m; j++) {
                important = important + cin.nextDouble() / 2.00;
            }
            People people = new People(important, i);
            list.add(people);
            i++;
        }
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if(o1.getVal() != o2.getVal()) {
                    return o2.val.compareTo(o1.val);
                } else {
                    return o1.id - o2.id;
                }
            }
        });
        i = 0;
        for(i = 0; i < m; i++) {
            People people = list.get(i);
            if(people.id == id) {
                break;
            }
        }
        System.out.println(++i);

    }
}
class People {
    Double val;
    int id;

    public People(Double val, int id) {
        this.val = val;
        this.id = id;
    }

    public Double getVal() {
        return val;
    }

    public int getId() {
        return id;
    }
}
