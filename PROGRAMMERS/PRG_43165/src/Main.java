import javax.swing.*;

class Solution {
    int len = 0;
    int answer = 0;
    int target = 0;
    int []num;

    public int solution(int[] numbers, int target) {
        len = numbers.length;
        this.target = target;
        num = numbers;
        solve(0, 0);

        return answer;
    }
    /*
        문제의 중요한 점은 어떤 것이 몇 번째에 쓰이냐 마느냐의 문제가 아님
        왜냐하면 어차피 더하고 빼는데 순서는 중요하지 않기 때문임
     */

    public void solve(int idx, int sum) {
        if (idx == len) {
            if (target == sum)
                answer++;
            return;
        }

        solve(idx + 1, sum + num[idx]);
        solve(idx + 1, sum - num[idx]);
    }
}

public class Main {
    public static void main(String[] args) {
        int []arr = {1, 1, 1, 1, 1};
        new Solution().solution(arr, 3);
    }
}
