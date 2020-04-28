import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

class FirstUnique {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> queue = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            queue.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public int showFirstUnique() {
        for (int num : queue) {
            if (map.get(num) == 1)
                return num;
        }
        return -1;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        queue.add(value);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
