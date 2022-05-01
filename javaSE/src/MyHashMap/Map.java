package MyHashMap;

public interface Map<K,V> {
    V put(K k, V v);
    V get(K k);
    int size();

    //写这个的目的是希望实现类能够强制实现这个内部类
    interface Entry<K,V> {
        K getKey();
        V getValue();
    }
}
