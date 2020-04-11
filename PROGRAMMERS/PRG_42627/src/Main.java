import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });

        int idx = 0;
        int time = 0;
        int answer = 0;

        while (idx < jobs.length || q.size() > 0) {
            while (idx < jobs.length && time >= jobs[idx][0]) {
                q.add(new Pair(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (q.size() > 0) {
                Pair p = q.remove();
                time += p.val;
                answer += time - p.idx;
            }
            else {
                time++;
            }
        }
        return answer / jobs.length;
    }

    class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{0, 3}, {1, 9}, {2, 6}};
        /*
         */
        System.out.println(new Solution().solution(a));
    }
}
