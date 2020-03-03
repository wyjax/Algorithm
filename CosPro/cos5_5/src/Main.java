// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    public int solution(int[] enemies, int[] armies) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        Arrays.sort(enemies);
        Arrays.sort(armies);
        int idx = 0;
        for (int i = 0; i < armies.length; i++) {
            if (armies[i] >= enemies[idx]) {
                answer++;
                idx++;
            }
            if (idx == enemies.length)
                break;
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] enemies1 = {1, 4, 37,4,43,34,56,5,3,2,2,4,5,3,2,3,45,5,4,3,3,6,1,2,3,5,56,3,2,2,54};
        int[] armies1 = {3, 1,4,5,6,87,3,23,5,4,34,23,4,};
        int ret1 = sol.solution(enemies1, armies1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] enemies2 = {1, 1, 1};
        int[] armies2 = {1, 2, 3, 4};
        int ret2 = sol.solution(enemies2, armies2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}