

class Solution {
    int n_cnt;

    public int solution(int n) {
        int answer;
        n_cnt = check(n);

        for (int i = n + 1; ; i++) {
            int next_cnt = check(i);

            if (next_cnt == n_cnt) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public int check(int n) {
        int cnt = 0;

        while (n > 0) {
            if (n % 2 == 1)
                cnt++;
            n /= 2;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(78));
    }
}
