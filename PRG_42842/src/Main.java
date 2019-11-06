
class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        int sum = brown + red;
        for(int i = 2; i < sum / 2; i++) {
            if (sum % i > 0) continue;
            int a = sum / i;

            int tmp = (i + i) + ((a - 2) * 2);
            if (tmp == brown) {
                answer[0] = a;
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(8, 1);
    }
}
