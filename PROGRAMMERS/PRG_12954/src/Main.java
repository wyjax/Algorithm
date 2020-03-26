public class Main {
    public static void main(String[] args) {
        new Solution().solution(-10000000, 1000);
    }
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) i * (long) x;
        }

        return answer;
    }
}