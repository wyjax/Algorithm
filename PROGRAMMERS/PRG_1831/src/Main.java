
class Solution {
    int answer;

    public int solution(int n) {
        answer = 0;
        cal(0, n);
        return answer;
    }

    public void cal(int add, int n) {
        if (Math.pow(3, add / 2) > n) return;
        // 처음에는 *로 시작해야한다.
        if (n == 3) {
            if (add == 2) {
                answer++;
            }
        }
        else if (n > 3) {
            if (add >= 2 && n % 3 == 0)
                cal(add - 2, n / 3);
            cal(add + 1, n - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2147483647));
    }
}

// *+ *+ *+ ++ ++ ++
// 34 12 13 3637 3839 4041 4243
// * : + = 1 : 2
//  *+*+++
// 3 4 12 13 14 15
// 15 14 13 12 4 3 1
// *+*++