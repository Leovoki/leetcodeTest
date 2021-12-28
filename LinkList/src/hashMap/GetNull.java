package hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leovoki
 * @version 1.0 update on 2021/12/21
 */
public class GetNull {
    public static void main(String[] args)
    {
        Map<Integer,String> temp = new HashMap<>();
        temp.put(1,"你好");
        temp.put(2,"aa");
        System.out.println(temp);
        Integer value = null;
        System.out.println(temp.get(value));
        System.out.println(temp.get(100));
        String value2 = temp.get(value);
        String value3 = temp.get(100);
    }
}
