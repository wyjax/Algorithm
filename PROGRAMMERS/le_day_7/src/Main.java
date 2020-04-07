import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 5, 0};
        int[] a2 = {1, 1, 2, 2};
        System.out.println(new Solution().countElements(a2));
    }
}

class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        // set에 넣었다. 같은 숫자가 얼마나 있을지 몰라서
        // O(n)
        for (int num : arr) {
            set.add(num);
        }
        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int next = arr[i] + 1;
            if (set.contains(next))
                answer++;
        }
        return answer;
    }
}