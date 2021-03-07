import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class MyHashMap {
    private Set<Integer> set = new LinkedHashSet<>();
    private List<Integer> keyList;
    private List<Integer> valueList;

    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    public void put(int key, int value) {
        int idx = contain(key);

        if (idx == -1) {
            keyList.add(key);
            valueList.add(value);

            return;
        }

        valueList.set(idx, value);
    }

    public int get(int key) {
        int idx = contain(key);

        return (idx == -1) ? idx : valueList.get(idx);
    }

    public void remove(int key) {
        int idx = contain(key);

        if (idx == -1) {
            return;
        }

        keyList.remove(idx);
        valueList.remove(idx);
    }

    private int contain(int key) {
        return keyList.indexOf(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
