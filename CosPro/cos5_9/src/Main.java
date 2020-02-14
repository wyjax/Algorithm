// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    public int solution(int number, int target) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int[] a = new int[10001];
        Arrays.fill(a, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(number);
        a[number] = 0;

        while (q.size() > 0) {
            int x = q.remove();

            if (x == target)
                return a[x];

            for (int num : new int[]{x - 1, x + 1, x * 2}) {
                if (num < 0 || num > 10000) continue;
                if (a[num] != -1) continue;
                a[num] = a[x] + 1;
                q.add(num);
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int number1 = 5;
        int target1 = 9;
        int ret1 = sol.solution(number1, target1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int number2 = 3;
        int target2 = 11;
        int ret2 = sol.solution(number2, target2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}