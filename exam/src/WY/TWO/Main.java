package WY.TWO;

import java.util.*;

public class Main {
    private static Integer maxAns = -1;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int n = 0;
        //List<Yh> one = new ArrayList<>();
        while(t-- > 0) {
            maxAns = -1;
            n = cin.nextInt();//这组几个御魂
            Map<Integer, List<Yh>> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                Integer pos = cin.nextInt();
                List<Yh> yhList = map.getOrDefault(pos,new ArrayList<>());
                Yh yh = new Yh(pos, cin.nextInt(), cin.nextInt());
                yhList.add(yh);
                map.put(pos, yhList);
                Collections.sort(yhList, new Comparator<Yh>() {
                    @Override
                    public int compare(Yh o1, Yh o2) {
                        return o2.bRate.compareTo(o1.bRate);
                    }
                });
            }
            //装配完毕
            findMax(map.get(1), map, 1, 0, 0);
            if(maxAns == -1) {
                System.out.println("TAT");
            } else {
                System.out.println(maxAns);
            }
        }
    }

    public static void findMax(List<Yh> list,Map<Integer,List<Yh>> map, int pos, int sumBRate, int sumHurt) {
        if(pos == 7) {
            //说明已经是第七个位置了，开始处理
            if(sumBRate >= 100) {
                //暴击率100
                maxAns = Math.max(maxAns, sumHurt);
            }
            return;
        }
        //当前位置
        for(Yh yh : list) {
            //剪纸
            //还剩多少个位置没算
            int rest = 6 - pos;
            if(sumBRate + yh.bRate + rest * 25 < 100) break;
            findMax(map.get(yh.pos+1),map, yh.pos + 1, sumBRate + yh.bRate, sumHurt + yh.hurt);
        }


    }

    static class Yh{
        Integer pos;
        Integer bRate;//暴力率
        Integer hurt;

        public Yh(int pos, int bRate, int hurt) {
            this.pos = pos;
            this.bRate = bRate;
            this.hurt = hurt;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public void setBRate(int bRate) {
            this.bRate = bRate;
        }

        public void setHurt(int hurt) {
            this.hurt = hurt;
        }
    }
}
