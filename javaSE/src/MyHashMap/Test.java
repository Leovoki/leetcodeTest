package MyHashMap;

public class Test {
    public static void main(String[] args) {
        Map<Object,Integer> map = new HashMap<>();
        for(int i = 0; i < 1000000000; i++) {
            map.put("张三" + i,20 + i);
            System.out.println(map.get("张三" + i));
        }
    }
}
