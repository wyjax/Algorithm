import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : scoville) {
            q.add(num);
        }

        if (q.peek() >= K)
            return 0;
        if (q.size() == 1) {
            return -1;
        }

        while (q.size() > 1) {
            int first = q.remove();
            if (first >= K)
                return answer;

            int second = q.remove();
            int next = first + (second * 2);
            answer++;
            q.add(next);
        }
        if (q.peek() >= K)
            return answer;

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 9, 10, 12};
        System.out.println(new Solution().solution(a, 7));
    }
}