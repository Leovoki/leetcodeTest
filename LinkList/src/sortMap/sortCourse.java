package sortMap;

import java.util.*;

/**
 * @author Leovoki
 * @version 1.0 update on 2021/12/7
 */
public class sortCourse {

        public static void main(String[] args)
        {
            Map<String, Integer> map = new HashMap<>();
            map.put("王二", 8);
            map.put("沈吴", 2);
            map.put("小菜", 3);
            map.put("大鸟", 1);

            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            for (Map.Entry s : entrySet)
            {
                System.out.println(s.getKey()+"--"+s.getValue());
            }

            System.out.println("============排序后============");

            //////借助list实现hashMap排序//////

            //注意 ArrayList<>() 括号里要传入map.entrySet()
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
            {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                {
                    //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

                    //按照value值，从大到小排序
//                return o2.getValue() - o1.getValue();

                    //按照value值，用compareTo()方法默认是从小到大排序
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            //注意这里遍历的是list，也就是我们将map.Entry放进了list，排序后的集合
            for (Map.Entry s : list)
            {
                System.out.println(s.getKey()+"--"+s.getValue());
            }

        }
}
