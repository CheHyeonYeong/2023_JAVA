package Week05_chy.Week05_02;
package Generic;

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
public class ContainerEx {
    public static void main(String[] args){
        Week05_02<String, String> c1 = new Week05_02<String,String>();
        c1.set("홍길동", "도적");
        String name1 = c1.getKey();
        String job = c1.getValue();


        Week05_02<String, Integer> c2 = new Week05_02<String,Integer>();
        c1.set("홍길동", 35);
        String name2 = c1.getKey();
        String age = c1.getValue();

    }
}

