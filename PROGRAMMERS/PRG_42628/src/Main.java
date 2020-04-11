import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        StringTokenizer st;
        int cnt = 0;
        Queue<Integer> maxq = new PriorityQueue<>();
        Queue<Integer> minq = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            char first = st.nextToken().charAt(0);
            int second = Integer.parseInt(st.nextToken());

            if (first == 'I') {
                maxq.add(-second);
                minq.add(second);
                cnt++;
            }
            else if (cnt-- > 0) {
                if (second < 0)
                    minq.remove();
                else
                    maxq.remove();
                if (cnt == 0) {
                    maxq.clear();
                    minq.clear();
                }
            }
        }
        if (cnt > 0) {
            answer[0] = -maxq.remove();
            answer[1] = minq.remove();
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] a = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] b = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] c = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        System.out.println();
        new Solution().solution(c);
    }
}

//