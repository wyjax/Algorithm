// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    public int solution(String s1, String s2) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int len = Math.min(s1.length(), s2.length());

        // abcde
        // deabc
        for (int i = 0; i < s1.length(); i++) {
            int tmp = 0;
            for (int j = 0; j < s2.length() && i + j < s1.length(); j++) {
                if (s1.charAt(i + j) == s2.charAt(j))
                    tmp++;
                else
                    break;
                if (j == s2.length() - 1 || i + j == s1.length() - 1)
                    answer = Math.max(tmp, answer);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            int tmp = 0;
            for (int j = 0; j < s1.length() && i + j < s2.length(); j++) {
                if (s2.charAt(i + j) == s1.charAt(j))
                    tmp++;
                else
                    break;
                if (j == s1.length() - 1 || i + j == s2.length() - 1)
                    answer = Math.max(tmp, answer);
            }
        }

        return s1.length() + s2.length() - answer;
    }

    public int solution2(String s1, String s2) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int len = Math.min(s1.length(), s2.length());

        for (int i = 1; i <= len; i++) {
            if (s1.substring(s1.length() - i, s1.length()).equals(s2.substring(0, i))) {
                answer = i;
            }
            if (s2.substring(s2.length() - i, s2.length()).equals(s1.substring(0, i))) {
                answer = i;
            }
        }
        return s1.length() + s2.length() - answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String s2 = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
        int ret = sol.solution(s1, s2);
        int ret2 = sol.solution2(s1, s2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}