package Week05_chy.Week05_02;

public class Week05_02<K,V> {
    public K k;
    public V v;
    public K getKey(){
        return this.k;
    }
    public V getValue(){
        return this.v;
    }

    public void set(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

