import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManyMap {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        map.put("name","张三");
        concurrentHashMap.put("name","李四");
        map.get("name");
        concurrentHashMap.get("name");
    }
}
