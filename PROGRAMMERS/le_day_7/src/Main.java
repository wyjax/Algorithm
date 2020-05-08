import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 5, 0};
        int[] a2 = {1, 1, 2, 2};
        int[] a3 = {1, 1, 2, 3};
        System.out.println(new Solution().countElements3(a3));
    }
}

class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int next = arr[i] + 1;
            if (set.contains(next))
                answer++;
        }
        return answer;
    }

    public int countElements2(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int next = arr[i] + 1;
            if (set.contains(next)) {
                answer++;
                set.remove(next);
            }
        }
        return answer;
    }

    public int countElements3(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, true);
        }
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int next = arr[i] + 1;
            if (map.containsKey(next) && map.get(next) == true) {
                answer++;
                map.put(next, false);
            }
        }
        return answer;
    }
}