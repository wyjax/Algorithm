
class Solution {
    public int solution(int n) {
        int answer = 1;
        int max = (n / 2) + 1;

        for (int i = 1; i <= max; i++) {
            int sum = i;

            for (int j = i + 1; j <= max; j++) {
                if (sum + j >= n) {
                    if (sum + j == n)
                        answer++;
                    break;
                }
                sum += j;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }
}
