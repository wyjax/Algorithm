// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int a, int b) {
        // 여기에 코드를 작성해주세요.
        int maxs = 40000;
        int answer = 0;
        boolean[] prime = new boolean[maxs];
        for (int i = 2; i < maxs; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < maxs; j += i)
                    prime[j] = true;
            }
        }

        for (int i = 2; i < 10001; i++) {
            if (!prime[i]) {
                int po2 = i * i;
                int po3 = i * i * i;

                if (a <= po2 && po2 <= b)
                    answer++;
                if (a <= po3 && po3 <= b)
                    answer++;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args){
        Solution sol = new Solution();
        int a = 1;
        int b = 1000000000;
        int ret = sol.solution(a, b);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}