import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        int cur_weight = 0;
        int idx = 0;
        int next = 0;

        while (idx < truck_weights.length) {
            answer++;

            int tmp = truck_weights[idx];
            if (cur_weight + tmp <= weight) {
                idx++;
                cur_weight += tmp;
                q.offer(0);
            }

            for (int i = 0; i < q.size(); i++) {
                int n = q.poll() + 1;
                q.offer(n);
            }

            if (q.peek() == bridge_length) {
                cur_weight -= truck_weights[next++];
                q.poll();
            }
        }
        answer += bridge_length;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int arr[] = {7, 4, 5, 6};
        new Solution().solution(2, 10, arr);
    }
}