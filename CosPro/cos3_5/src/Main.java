// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    public String solution(String phrases, int second) {
        String answer = "";
        int len = phrases.length();
        second = second % (len * 2); // 0 ~ 27

        if (second < len) {
            for (int i = 0; i < len - second; i++)
                answer += "_";
            answer = answer + phrases.substring(0, second);
        }
        else {
            for (int i = 0; i < second - len; i++)
                answer += "_";
            answer = phrases.substring(second - len, len) + answer;
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String phrases = new String("happy-birthday");

        int second = 14;
        for (int i = 0; i < 50; i++) {
            String ret = sol.solution(phrases, i);
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
        }

    }
}