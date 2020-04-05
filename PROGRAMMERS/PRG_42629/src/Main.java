import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        if (stock >= k)
            return answer;

        Queue<Integer> q = new PriorityQueue<>();
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (idx < dates.length && i == dates[idx])
                q.add(-supplies[idx++]);
            if (stock == 0) {
                stock += -q.remove();
                answer++;
            }
            stock--;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {4, 10, 15};
        int[] b = {20, 5, 10};

        System.out.println(new Solution().solution(4, a, b, 30));
    }
}
