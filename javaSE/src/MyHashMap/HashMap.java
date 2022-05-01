package MyHashMap;

public class HashMap<K,V> implements Map<K,V>{
    Entry<K,V>[] table = null;
    int size = 0;


    public HashMap() {
        table = new Entry[16];
    }

    /**
     * 1、根据K算出哈希值 取模
     * 2、获得数组的下标位置 查看是否为空
     * 3、如果为空 可以直接存储；
     * 4、如果不为空用链表存储
     * 5、返回V
     * @return
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if(null == entry) {
            table[index] = new Entry<>(k,v,index,null);
            size++;
        } else {
            //聊表存储
            table[index] = new Entry<K, V>(k,v,index,entry);//构造next
        }
        return table[index].getValue();
    }

    public int hash(K k) {
        return Math.abs(k.hashCode() % 15);
    }

    /**
     * 1、k算出hash
     *判断k是否相等，如果相等直接返回
     * 不相等判断 next是否为空 不为空 则再次比较是否相等
     * 直到比较到相等
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if(size == 0) {
            return null;
        }
        int index = hash(k);
        Entry<K,V> entry =  findValue(table[index], k);

        return entry == null ? null : entry.getValue();


    }

    private Entry<K,V> findValue(Entry<K,V> entry, K k) {
        if(entry == null) return null;
        if(k.equals(entry.getKey()) || k == entry.getKey()) {
            return entry;
        } else {
            //看看有没有链表
            if(entry.next != null) {
                return findValue(entry.next, k);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }


    class Entry<K,V> implements Map.Entry<K,V> {
        K k;
        V v;
        int hash;
        Entry<K,V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
