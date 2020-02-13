// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    public String solution(int hour, int minute) {
        // 여기에 코드를 작성해주세요.
        String answer = "";
        Double min_kak = Double.valueOf(6 * (minute % 60));
        Double hour_kak = Double.valueOf(30 * (hour % 12));

        System.out.println(hour_kak + " " + min_kak);

        if (min_kak > hour_kak) {
            Double tmp = min_kak;
            min_kak = hour_kak;
            hour_kak = tmp;
        }

        if (hour_kak - min_kak > 180.0)
            answer = Double.toString(360 - (hour_kak - min_kak));
        else
            answer = Double.toString(hour_kak - min_kak);

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int hour = 1;
        int minute = 59;
        String ret = sol.solution(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}